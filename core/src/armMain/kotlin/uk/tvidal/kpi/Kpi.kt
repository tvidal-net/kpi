package uk.tvidal.kpi

@ExperimentalUnsignedTypes
const val ON: UByte = 1u

@ExperimentalUnsignedTypes
const val OFF: UByte = 0u

@ExperimentalUnsignedTypes
fun u(it: Int): UInt = it.toUInt()

@ExperimentalUnsignedTypes
fun u(it: Byte): UByte = it.toUByte()

@ExperimentalUnsignedTypes
fun u(it: Boolean): UByte = if (it) ON else OFF
