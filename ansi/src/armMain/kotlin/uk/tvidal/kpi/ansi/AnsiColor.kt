package uk.tvidal.kpi.ansi

import uk.tvidal.kpi.ansi.AnsiStyle.Bold

enum class AnsiColor(val id: Byte) {
    Black(0),
    Red(1),
    Green(2),
    Yellow(3),
    Blue(4),
    Magenta(5),
    Cyan(6),
    White(7);

    operator fun invoke(it: Any?, style: AnsiStyle = Bold) =
        it?.ansiString(this, null, style)
            .orEmpty()
}
