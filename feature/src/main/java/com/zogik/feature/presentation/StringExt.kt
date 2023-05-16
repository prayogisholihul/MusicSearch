package com.zogik.feature.presentation

fun Map<String, String>.mapExt(): String {
    var result = ""
    for (item in this) {
        result = "${item.key}:'${item.value}'"
    }
    return result
}
