package com.zogik.core.utils

import java.math.BigInteger
import java.security.MessageDigest

fun String.convertImage(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
}
