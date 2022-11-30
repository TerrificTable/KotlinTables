package examples

import xyz.terrific.Table
import xyz.terrific.Tablealign
import xyz.terrific.csv.CSVReader
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer
import java.io.File

class FamilyGuy_Character(val firstname: String, val lastname: String)


fun main() {
    val csvData: ArrayList<List<String>> = CSVReader(File("src/main/kotlin/examples/family_guy_characters.csv"))
        .readCsv()

    val characters: ArrayList<FamilyGuy_Character> = ArrayList()
    for (line: List<String> in csvData) {
        characters.add(FamilyGuy_Character(line[0], line[1]))
    }


    val values  = arrayListOf<Cell>()
    val headers = Cell(arrayListOf("firstname", "lastname"))
    val footer  = Footer("Family Guy Characters", Tablealign.CENTER)

    for (character: FamilyGuy_Character in characters) {
        values.add(Cell(arrayListOf(character.firstname, character.lastname)))
    }


    Table(headers, values, footer).print()
}

