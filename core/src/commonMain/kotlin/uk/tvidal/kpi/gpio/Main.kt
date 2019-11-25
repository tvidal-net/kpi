package uk.tvidal.kpi.gpio

import uk.tvidal.kpi.GpioPin.P18
import uk.tvidal.kpi.Pi

fun main() {
    Pi.toggle(P18)
}
