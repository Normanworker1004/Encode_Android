package com.sweetwater.encore.dependency_injection.mqtt

import android.util.Log
import com.hivemq.client.mqtt.datatypes.MqttQos
import com.hivemq.client.mqtt.mqtt5.Mqtt5AsyncClient
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish
import com.sweetwater.encore.BuildConfig
import kotlinx.coroutines.future.await
import java.util.UUID

class MqttService : IMqttService {
    private val mqttClient: Mqtt5AsyncClient

    private val _deviceIdentifier: String = UUID.randomUUID().toString();
    override val deviceIdentifier: String
        get() = _deviceIdentifier

    init {
        val client = Mqtt5Client.builder()
            .identifier(_deviceIdentifier)
            .serverHost(BuildConfig.MQTT_SERVER_URL)
            .serverPort(BuildConfig.MQTT_SERVER_PORT)
            .automaticReconnectWithDefaultConfig()
            .buildBlocking()

        this.mqttClient = client.toAsync()
    }


    override suspend fun connect() {
        try {
            mqttClient.connectWith()
                .cleanStart(true)
                .keepAlive(5)
                .send()
                .await()
        } catch (e: Exception) {
            Log.e("TAG", "MQTT Connect Error: ${e.message}")
        }
    }

    override suspend fun disconnect() {
        try {
            mqttClient
                .disconnect()
                .await()
        } catch (e: Exception) {
            Log.e("TAG", "MQTT Disconnect Error: ${e.message}")
        }
    }

    override suspend fun subscribe(
        topic: String,
        onMessageReceived: (message: Mqtt5Publish) -> Unit
    ) {
        try {
            mqttClient.subscribeWith()
                .topicFilter(topic)
                .qos(MqttQos.AT_MOST_ONCE)
                .callback(onMessageReceived)
                .send()
                .await()
        } catch (e: Exception) {
            Log.e("TAG", "MQTT Subscribe Error: ${e.message}")
        }
    }

    override suspend fun publish(topic: String, message: String) {
        try {
            mqttClient.publishWith()
                .topic(topic)
                .qos(MqttQos.AT_MOST_ONCE)
                .payload(message.toByteArray(Charsets.UTF_8))
                .send()
                .await()
        } catch (e: Exception) {
            Log.e("TAG", "MQTT Publish Error: ${e.message}")
        }
    }
}