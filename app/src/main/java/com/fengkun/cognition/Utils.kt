package com.fengkun.cognition

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

fun getAssetData(context: Context, fileName: String): String {
    var stringBuilder: StringBuilder = StringBuilder()
    try {
        var bufferedReader: BufferedReader =
            BufferedReader(InputStreamReader(context.assets.open(fileName), "utf-8"))
        var line: String?
        while ((bufferedReader.readLine().also { line = it }) != null)
            stringBuilder.append(line?.trim())
    } catch (e: IOException) {
    }
    return stringBuilder.toString()
}