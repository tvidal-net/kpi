package uk.tvidal.kpi.gpio

import uk.tvidal.kpi.GpioPin

interface GpioService {
    fun on(pin: GpioPin)
    fun off(pin: GpioPin)
}
