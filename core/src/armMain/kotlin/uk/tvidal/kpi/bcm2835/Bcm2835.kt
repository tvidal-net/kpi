package uk.tvidal.kpi.bcm2835

import bcm2835.bcm2835_delay
import bcm2835.bcm2835_delayMicroseconds
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

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

@ExperimentalUnsignedTypes
fun delay(millis: Int) = bcm2835_delay(millis.toUInt())

@ExperimentalUnsignedTypes
fun delayMicros(micros: Long) = bcm2835_delayMicroseconds(micros.toULong())

@ExperimentalTime
@ExperimentalUnsignedTypes
fun delay(duration: Duration) {
    delayMicros(duration.toLongNanoseconds() / 1000L)
}
