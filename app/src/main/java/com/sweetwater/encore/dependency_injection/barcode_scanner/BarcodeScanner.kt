package com.sweetwater.encore.dependency_injection.barcode_scanner

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.RECEIVER_EXPORTED
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.util.Log
import com.cipherlab.barcode.GeneralString
import com.cipherlab.barcode.ReaderManager
import com.cipherlab.barcode.decoder.BcReaderType
import com.cipherlab.barcode.decoder.Enable_State
import com.cipherlab.barcode.decoder.IlluminationPowerLevel
import com.cipherlab.barcode.decoderparams.NotificationParams
import com.cipherlab.barcode.decoderparams.UserPreference
import com.cipherlab.barcodebase.ReaderCallback
import javax.inject.Inject

class BarcodeScanner @Inject constructor(
    context: Context
) : ReaderCallback, IBarcodeScanner {
    private lateinit var readerManager: ReaderManager
    private var readerCallback: ReaderCallback? = null

    private val dataReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action.equals(GeneralString.Intent_READERSERVICE_CONNECTED)){
                readerManager = ReaderManager.InitInstance(context)
            }
            val userPreferences = UserPreference()
            readerManager.Get_UserPreferences(userPreferences)
            val notificationParams = NotificationParams()
            val bcReaderType: BcReaderType = readerManager.GetReaderType()
            Log.d("TAG", "onReceive: Reader Type : $bcReaderType")
            readerManager.Get_NotificationParams(notificationParams)
            if (intent?.action == GeneralString.Intent_READERSERVICE_CONNECTED) { // Configure defaults once reader is connected
                userPreferences.decodingIllumination =
                    Enable_State.TRUE //Enable barcode illumination
                userPreferences.decodingIlluminationPowerLevel =
                    IlluminationPowerLevel.Ten //Set power level of illumination
                readerManager.Set_UserPreferences(userPreferences)
                notificationParams.enableVibrator =
                    Enable_State.FALSE // Disable vibration feedback on successful scan
                readerManager.Set_NotificationParams(notificationParams)
                if (readerCallback != null) {
                    readerManager.SetReaderCallback(readerCallback)
                }
            }
        }
    }

    override var onBarcodeScanned: (barcode: String) -> Unit = {}

    init {
        readerCallback = this

        val filter = IntentFilter()
        filter.addAction(GeneralString.Intent_READERSERVICE_CONNECTED)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(dataReceiver, filter, RECEIVER_EXPORTED)
        } else {
            context.registerReceiver(dataReceiver, filter)
        }
    }

    override fun asBinder(): IBinder {
        TODO("Not yet implemented")
    }

    override fun onDecodeComplete(decodedText: String?) {
        val cleanedDecodedText = decodedText!!.replace("\n", "")
        if (cleanedDecodedText.isEmpty()) {
            return
        }

        onBarcodeScanned(cleanedDecodedText)
    }
}