package uk.tvidal.kpi.gpio

import uk.tvidal.kpi.Pin

interface GpioService {
    fun on(pin: Pin)
    fun off(pin: Pin)
}
