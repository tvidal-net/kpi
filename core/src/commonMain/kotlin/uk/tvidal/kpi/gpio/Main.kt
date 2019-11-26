package uk.tvidal.kpi.gpio

import uk.tvidal.kpi.GpioPin.P1_12
import uk.tvidal.kpi.Pi
import uk.tvidal.kpi.gpio.GpioMode.OUTPUT

fun main() {
    Pi[P1_12] = OUTPUT
    Pi.toggle(P1_12)
}
