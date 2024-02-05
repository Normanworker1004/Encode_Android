package com.sweetwater.encore.recounts.data.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.sweetwater.encore.RecountsData
import java.io.InputStream
import java.io.OutputStream

object RecountsDataSerializer : Serializer<RecountsData> {
    override val defaultValue: RecountsData = RecountsData.getDefaultInstance()
    override suspend fun readFrom(input: InputStream): RecountsData {
        try {
            return RecountsData.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: RecountsData, output: OutputStream) = t.writeTo(output)
}