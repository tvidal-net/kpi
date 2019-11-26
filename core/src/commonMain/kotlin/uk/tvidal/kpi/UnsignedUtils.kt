package uk.tvidal.kpi

const val HIGH: UByte = 1u
const val LOW: UByte = 0u

fun u(byte: Byte) = byte.toUByte()

fun u(int: Int) = int.toUInt()

fun u(boolean: Boolean): UByte = if (boolean) HIGH else LOW
