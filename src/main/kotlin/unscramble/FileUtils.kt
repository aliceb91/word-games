package unscramble

import java.io.File

open class FileUtils {

    open fun readFromClassPath(): List<String> {
        return this::class.java.getResourceAsStream("words.txt")
            .bufferedReader()
            .readLines()
    }

    open fun readFromPath(filePath: String): List<String> {
        val data = File(filePath)
        if (data.exists()) {
            return data.inputStream()
                .bufferedReader()
                .readLines()
        } else {
            return readFromClassPath()
        }
    }
}