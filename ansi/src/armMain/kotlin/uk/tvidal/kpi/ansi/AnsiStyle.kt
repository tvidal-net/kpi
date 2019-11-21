package uk.tvidal.kpi.ansi

enum class AnsiStyle(val id: Byte) {
    Normal(0),
    Bold(1),
    Underscore(4),
    Blink(5),
    Reverse(7);
}
