package examples

import xyz.terrific.Table
import xyz.terrific.Tablealign
import xyz.terrific.csv.CSVReader
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer
import java.io.File

class Name(val firstname: String, val lastname: String)


fun main() {
    val csvData: ArrayList<List<String>> = CSVReader(File("src/main/kotlin/examples/names.csv"))
        .readCsv()

    val characters: ArrayList<Name> = ArrayList()
    for (line: List<String> in csvData) {
        characters.add(Name(line[0], line[1]))
    }


    val values  = arrayListOf<Cell>()
    val headers = Cell(arrayListOf("firstname", "lastname"))
    val footer  = Footer("Names", Tablealign.CENTER)

    for (character: Name in characters) {
        values.add(Cell(arrayListOf(character.firstname, character.lastname)))
    }


    Table(headers, values, footer).print()
}

