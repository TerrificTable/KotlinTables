package examples

import xyz.terrific.Table
import xyz.terrific.Tablealign
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer

fun main() {
    val headers = Cell(arrayListOf("firstname", "lastname"))
    val values  = arrayListOf(
        Cell(arrayListOf("Julian", "Douglas")),
        Cell(arrayListOf("Eden", "Gallagher")),
        Cell(arrayListOf("Helena", "Mcconnell")),
        Cell(arrayListOf("Kade", "Bright")),
        Cell(arrayListOf("Jordyn", "Garrett")),
        Cell(arrayListOf("Kaylin", "Lawson")),
    )
    val footer  = Footer("Names", Tablealign.CENTER)

    Table(headers, values, footer).print()
}

