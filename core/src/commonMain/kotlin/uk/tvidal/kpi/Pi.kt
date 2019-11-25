package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue

expect object Pi {

    fun on(pin: GpioPin)
    fun off(pin: GpioPin)
    fun toggle(pin: GpioPin)

    operator fun get(pin: GpioPin): GpioValue

    operator fun set(pin: GpioPin, value: GpioValue)
    operator fun set(pin: GpioPin, mode: GpioMode)

    operator fun invoke(pin: GpioPin): Boolean
}
