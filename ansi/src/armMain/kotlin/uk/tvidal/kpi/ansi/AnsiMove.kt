package uk.tvidal.kpi.ansi

object AnsiMove {

    fun nextLine(lines: Byte? = null) = move('E', lines)
    fun prevLine(lines: Byte? = null) = move('F', lines)

    fun up(lines: Byte? = null) = move('A', lines)
    fun down(lines: Byte? = null) = move('B', lines)

    fun right(columns: Byte? = null) = move('C', columns)
    fun left(columns: Byte? = null) = move('D', columns)

    fun column(column: Byte? = null) = move('G', column)

    fun save() = move('s')
    fun restore() = move('u')

    fun clearScreen(code: Byte = 2) = move('J', code)
    fun clearLine(code: Byte = 2) = move('K', code)

    fun scrollUp(lines: Byte? = null) = move('S', lines)
    fun scrollDown(lines: Byte? = null) = move('T', lines)

    fun move(dir: Char, amount: Byte? = null) = print(
        withAnsi {
            if (amount != null) append(amount)
            append(dir)
        }
    )

    fun pos(line: Byte, column: Byte) = print(
        withAnsi {
            append(line)
            append(';')
            append(column)
            append('H')
        }
    )
}
