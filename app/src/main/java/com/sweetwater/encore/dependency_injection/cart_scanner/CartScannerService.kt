package com.sweetwater.encore.dependency_injection.cart_scanner

import androidx.compose.ui.text.input.KeyboardType
import com.google.gson.Gson
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartError
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.CartScannerScreenInstructions
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.DecodedCartMessage
import com.sweetwater.encore.dependency_injection.cart_scanner.dto.ScannerTopicMessage
import com.sweetwater.encore.dependency_injection.mqtt.IMqttService
import java.nio.charset.StandardCharsets
import javax.inject.Inject


class CartScannerService @Inject constructor(
    private val mqttService: IMqttService,
) : ICartScannerService {
    private var _currentInstructions: CartScannerScreenInstructions? = null
    override val currentInstructions: CartScannerScreenInstructions?
        get() = _currentInstructions

    private var _cartIdentifier: String = ""
    override val cartIdentifier: String
        get() = _cartIdentifier

    override var onInstructions: (instructions: CartScannerScreenInstructions) -> Unit = {}
    override var onUnregistered: () -> Unit = {}
    override var onRegistered: () -> Unit = {}
    override var onError: (error: CartError) -> Unit = {}

    override suspend fun sendMessageToCart(message: String) {
        mqttService.publish(
            "dc/devices/receive/${cartIdentifier}",
            "{ \"action\": \"scan\", \"data\": [ \"input\", \"${message}\" ] }"
        )
    }

    override suspend fun registerCart(cartIdentifier: String) {
        _cartIdentifier = cartIdentifier

        mqttService.connect()
        subscribeToScannersTopic()
        mqttService.publish(
            "dc/devices/register/${cartIdentifier}",
            "{ \"action\": \"register\", \"data\": [ \"deviceId\", \"${mqttService.deviceIdentifier}\" ] }"
        )
    }

    override suspend fun unregisterCart() {
        mqttService.publish(
            "dc/devices/receive/${cartIdentifier}",
            "{ \"action\": \"unregister\", \"data\": [] }"
        )
        mqttService.disconnect()
    }

    private suspend fun subscribeToScannersTopic() {
        mqttService.subscribe("dc/scanners/${mqttService.deviceIdentifier}") { message ->
            val cartMessage = handleMqttMessagesFromScannerTopic(
                message
            )

            if (cartMessage.instructions != null) {
                _currentInstructions = cartMessage.instructions
                onInstructions(cartMessage.instructions)
            }
            if (cartMessage.isUnregistering) {
                onUnregistered()
            }
            if (cartMessage.isRegistering) {
                onRegistered()
            }
            if (cartMessage.error != null) {
                onError(cartMessage.error)
            }
        }
    }

    private fun handleMqttMessagesFromScannerTopic(message: Mqtt5Publish): DecodedCartMessage {
        val messageString =
            String(
                message.payloadAsBytes,
                StandardCharsets.UTF_8
            )

        val gson = Gson()

        val scannerTopicMessage =
            gson.fromJson(messageString, ScannerTopicMessage::class.java)

        when (scannerTopicMessage.action) {
            "register" -> {
                return handleRegisterMessage(scannerTopicMessage)
            }

            "unregister" -> {
                return handleUnregisterMessage(scannerTopicMessage)
            }

            "error" -> {
                return handleErrorMessage(scannerTopicMessage)
            }

            "instruct" -> {
                return handleInstructMessage(scannerTopicMessage)
            }
        }

        return DecodedCartMessage()
    }

    private fun handleRegisterMessage(scannerTopicMessage: ScannerTopicMessage): DecodedCartMessage {
        println("Received \"register\" action from cart: ${scannerTopicMessage.data}")

        return DecodedCartMessage(
            isRegistering = true,
        )
    }

    private fun handleUnregisterMessage(scannerTopicMessage: ScannerTopicMessage): DecodedCartMessage {
        println("Received \"unregister\" action from cart: ${scannerTopicMessage.data}")

        return DecodedCartMessage(
            isUnregistering = true,
        )
    }

    private fun handleErrorMessage(scannerTopicMessage: ScannerTopicMessage): DecodedCartMessage {
        println("Received \"error\" action from cart: ${scannerTopicMessage.data}")

        return DecodedCartMessage(
            error = CartError(
                title = scannerTopicMessage.getValue("title"),
                message = scannerTopicMessage.getValue("message")
            )
        )
    }

    private fun handleInstructMessage(scannerTopicMessage: ScannerTopicMessage): DecodedCartMessage {
        println("Received \"instruct\" action from cart: ${scannerTopicMessage.data}")

        val title = scannerTopicMessage.getValue("title")
        val subtitle1 = scannerTopicMessage.getValue("subtitle")
        val subtitle2 = scannerTopicMessage.getValue("subtitleTwo")
        val imageURL = scannerTopicMessage.getValue("image")
        val isKeyboardIconVisible = scannerTopicMessage.getValue("keyboardInput") != "hide"
        val keyboardType =
            when (scannerTopicMessage.getValue("keyboardInputType")) {
                "numberPad" -> KeyboardType.Number
                else -> KeyboardType.Text
            }

        return DecodedCartMessage(
            instructions = CartScannerScreenInstructions(
                title,
                subtitle1,
                subtitle2,
                imageURL,
                isKeyboardIconVisible,
                keyboardType
            )
        )
    }
}
