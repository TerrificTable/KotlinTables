package xyz.terrific.csv

import java.io.File

class CSVReader(private val csvFile: File) {

    fun readCsv(): ArrayList<List<String>> {
        val reader = csvFile.inputStream().bufferedReader()
        val header = reader.readLine()

        reader.lineSequence().filter { it.isNotBlank() }

        val data = ArrayList<List<String>>()
        for (line: String in reader.lineSequence()) {
            data.add(line.split(',', ignoreCase = false).map { it.trim() })
        }
        return data
    }

}
