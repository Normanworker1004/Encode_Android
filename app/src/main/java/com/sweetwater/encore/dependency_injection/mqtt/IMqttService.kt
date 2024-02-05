package com.sweetwater.encore.dependency_injection.mqtt

import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish

interface IMqttService {
    val deviceIdentifier: String

    suspend fun connect()
    suspend fun disconnect()
    suspend fun subscribe(topic: String, onMessageReceived: (message: Mqtt5Publish) -> Unit)
    suspend fun publish(topic: String, message: String)
}