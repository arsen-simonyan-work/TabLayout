package main.io

import kotlinx.serialization.json.Json
import java.io.File
import java.io.InputStream
import java.io.OutputStream

private val json = Json {
    ignoreUnknownKeys = true
}

internal inline fun <reified R : Any> convertToDataClass(value: String): R? {
    runCatching {
        json.decodeFromString<R>(value)
    }.onSuccess {
       return it
    }.onFailure {
        println(it.localizedMessage)
    }

    return null
}

fun readFile(fileName: String): String {
    runCatching {
        val configFile = File(System.getProperty("user.dir") + "//$fileName")
        val inputStream: InputStream = configFile.inputStream()
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        String(buffer)
    }.onSuccess {
        return it
    }.onFailure {
        println(it.localizedMessage)
    }

    return ""
}

fun writeFile(value: String) {
    runCatching {
        val userDirStr = File(System.getProperty("user.dir") + "//data.txt")
        val outputStream: OutputStream = userDirStr.outputStream()
        outputStream.write(value.toByteArray())
    }.onSuccess {
        println("Write to file success")
    }.onFailure {
        println("Write to file failed")
    }
}