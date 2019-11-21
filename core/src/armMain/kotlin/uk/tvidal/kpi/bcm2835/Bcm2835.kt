package uk.tvidal.kpi.bcm2835

import bcm2835.bcm2835_delay
import bcm2835.bcm2835_delayMicroseconds
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalUnsignedTypes
fun delay(millis: Int) = bcm2835_delay(millis.toUInt())

@ExperimentalUnsignedTypes
fun delayMicros(micros: Long) = bcm2835_delayMicroseconds(micros.toULong())

@ExperimentalTime
@ExperimentalUnsignedTypes
fun delay(duration: Duration) {
    delayMicros(duration.toLongNanoseconds() / 1000L)
}
