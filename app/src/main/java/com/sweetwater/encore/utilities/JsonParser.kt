package com.sweetwater.encore.utilities

import java.lang.reflect.Type

interface JsonParser {
    fun <T> parseJson(json: String, type: Type): T?
    fun <T> toJson(obj: T, type: Type): String?
}