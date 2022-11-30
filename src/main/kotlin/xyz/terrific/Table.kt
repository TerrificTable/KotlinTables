package xyz.terrific

import org.jetbrains.annotations.Nullable
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer

class Table(private var tableHeaders: Cell, private var tableContent: ArrayList<Cell>, @Nullable private var footer: Footer?) {
    constructor(tableHeaders: Cell, @Nullable footer: Footer?) : this(tableHeaders, arrayListOf(), footer)
    constructor(tableHeaders: Cell) : this(tableHeaders, arrayListOf(), Footer(null))

    fun print() {
        printHeaders()
        printSeparator(true)
        printData()
        if (footer?.data != null) {
            printSeparator(false)
            var len = 0
            for (i: String in tableHeaders.data) {
                len += (maxLen(tableHeaders.data.indexOf(i)) + 2)
            }
            println(Align(footer!!, len).align())
        }
    }


    private fun printHeaders() {
        for (i: String in tableHeaders.data) {
            print("$i  ${" ".repeat(maxLen(tableHeaders.data.indexOf(i)) - i.length)}")
        }
        println()
    }
    private fun printData() {
        for (i: Cell in tableContent) {
            for (j: String in i.data) {
                print("$j  ${" ".repeat(maxLen(i.data.indexOf(j)) - j.length)}")
            }
            println()
        }
    }
    private fun printSeparator(split: Boolean) {
        for (i: String in tableHeaders.data) {
            print("${"-".repeat(maxLen(tableHeaders.data.indexOf(i)))}${if (split) "  " else "--"}")
        }
        println()
    }

    private fun maxLen(idx: Int): Int {
        var maxLen = 0
        for (cell: Cell in tableContent) {
            if (cell.data[idx].length > maxLen)
                maxLen = cell.data[idx].length
        }
        return maxLen
    }
}
