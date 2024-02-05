package com.sweetwater.encore.helpers.extensions

fun String.removeNonNumericCharacters(): String {
    val nonNumericCharactersRegex = Regex("[\\s!-/:-~]")
    return this.replace(nonNumericCharactersRegex, "")
}