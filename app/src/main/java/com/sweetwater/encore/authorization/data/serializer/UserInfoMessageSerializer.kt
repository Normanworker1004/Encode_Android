package com.sweetwater.encore.authorization.data.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.sweetwater.encore.UserInfoMessage
import java.io.InputStream
import java.io.OutputStream

object UserInfoMessageSerializer: Serializer<UserInfoMessage> {
    override val defaultValue: UserInfoMessage = UserInfoMessage.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserInfoMessage {
        try {
            return UserInfoMessage.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserInfoMessage, output: OutputStream) {
        t.writeTo(output)
    }
}