package examples

import xyz.terrific.Table
import xyz.terrific.Tablealign
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer

fun main() {
    val headers = Cell(arrayListOf("firstname", "lastname"))
    val values  = arrayListOf(
        Cell(arrayListOf("Peter", "Griffin")),
        Cell(arrayListOf("Lois", "Griffin")),
        Cell(arrayListOf("Glenn", "Quagmire")),
        Cell(arrayListOf("Crystal", "Quagmire")),
        Cell(arrayListOf("Cleveland", "Brown")),
        Cell(arrayListOf("Loretta", "Brown")),
    )
    val footer  = Footer("Family Guy Characters", Tablealign.CENTER)

    Table(headers, values, footer).print()
}

