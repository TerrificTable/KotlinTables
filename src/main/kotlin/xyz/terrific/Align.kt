package xyz.terrific

import xyz.terrific.elements.Footer

class Align(val data: Any, var width: Int) {
    fun align(): String {
        width -= 2

        var res = data
        if (data is Footer) {
            res = when (data.align) {
                Tablealign.LEFT -> {
                    data.data!!
                }

                Tablealign.RIGHT -> {
                    " ".repeat(width - data.data!!.length) + data.data!!
                }

                Tablealign.CENTER -> {
                    if ((width/2) - (data.data!!.length/2) > 0) {
                        " ".repeat((width/2) - (data.data!!.length/2)) + data.data!!
                    } else {
                        data.data!!
                    }
                }
            }
        }
        return res as String
    }
}

enum class Tablealign {
    LEFT,
    CENTER,
    RIGHT
}
