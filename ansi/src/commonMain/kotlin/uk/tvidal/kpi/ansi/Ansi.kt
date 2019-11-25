package uk.tvidal.kpi.ansi

const val ESC = 0x1B.toChar()
const val SGR0 = "$ESC[m"

internal expect fun checkAnsiSupport(): Boolean

val hasAnsiSupport: Boolean
    get() = checkAnsiSupport()

inline fun withAnsi(
    default: String = "",
    block: StringBuilder.(String) -> Unit
) = when (hasAnsiSupport) {
    false -> default
    else -> buildString {
        append(ESC)
        append('[')
        block(default)
    }
}

fun Any.ansiString(
    fg: AnsiColor,
    bg: AnsiColor? = null,
    style: AnsiStyle? = null
) = withAnsi(toString()) {

    // style
    if (style != null) {
        append(style.id)
        append(';')
    }

    // foreground color
    append('3')
    append(fg.id)

    // background color
    if (bg != null) {
        append(";4")
        append(bg.id)
    }

    // terminate
    append('m')
    append(it)
    append(SGR0)
}
