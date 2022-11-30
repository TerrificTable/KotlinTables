package xyz.terrific

import org.jetbrains.annotations.Nullable
import xyz.terrific.elements.Cell
import xyz.terrific.elements.Footer

class Table(private var tableHeaders: Cell, private var tableContent: ArrayList<Cell>, @Nullable private var footer: Footer?) {
    constructor(tableHeaders: Cell, @Nullable footer: Footer?) : this(tableHeaders, arrayListOf(), footer)
    constructor(tableHeaders: Cell) : this(tableHeaders, arrayListOf(), Footer(null))

    fun print() {
        printHeaders()
        printData()
        if (footer?.data != null) {
            printSeparator()
            var len = 0
            for (i: String in tableHeaders.data) {
                len += (if (maxLen(tableHeaders.data.indexOf(i)) < i.length) i.length else maxLen(tableHeaders.data.indexOf(i)))
            }
            println(Align(footer!!, len + tableHeaders.data.size).align())
        }
    }


    private fun printHeaders() {
        for (i: String in tableHeaders.data) {
            val len = maxLen(tableHeaders.data.indexOf(i)) - i.length
            print("$i  ${" ".repeat(if (len < 0) 0 else len)}")
        }
        println()
        for (i: String in tableHeaders.data) {
            var len = maxLen(tableHeaders.data.indexOf(i))
            if (len < i.length) len = i.length
            print("${"-".repeat(len)}  ")
        }
        println()
    }
    private fun printData() {
        for (i: Cell in tableContent) {
            for (j: String in i.data) {
                var len = maxLen(i.data.indexOf(j))
                if (len < tableHeaders.data[i.data.indexOf(j)].length) len = tableHeaders.data[i.data.indexOf(j)].length
                len -= j.length
                print("$j  ${" ".repeat(len)}")
            }
            println()
        }
    }
    private fun printSeparator() {
        for (i: String in tableHeaders.data) {
            var len = maxLen(tableHeaders.data.indexOf(i))
            if (len < i.length) len = i.length
            print("-".repeat(len))
        }
        println("-".repeat(tableHeaders.data.size))
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
