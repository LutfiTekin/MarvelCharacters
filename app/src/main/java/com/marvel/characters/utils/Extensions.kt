package com.marvel.characters.utils

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

/**
 * Generate a hash from given timestamp
 */
fun Long.generateHash(): String{
    val publicKey = Firebase.remoteConfig.getString("public_key")
    val privateKey = Firebase.remoteConfig.getString("private_key")
    val hash = "$this$privateKey$publicKey"
    return hash.toMD5()
}


fun String.toMD5(): String {
    val md = MessageDigest.getInstance("MD5")
    val bigInt = BigInteger(1, md.digest(this.toByteArray(Charsets.UTF_8)))
    return String.format("%032x", bigInt)
}
const val START_DATE = "2005-01-01"
val dateRange: String
    get() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(System.currentTimeMillis())
        return "$START_DATE,$today"
    }