package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import uk.tvidal.kpi.gpio.GpioValue.OFF
import uk.tvidal.kpi.pwm.PwmService

interface PiService {

    val pwm: PwmService

    fun on(pin: GpioPin)
    fun off(pin: GpioPin)
    fun toggle(pin: GpioPin)

    fun high(pin: GpioPin) = on(pin)
    fun low(pin: GpioPin) = off(pin)

    operator fun get(pin: GpioPin): GpioValue

    operator fun set(pin: GpioPin, value: GpioValue)
    operator fun set(pin: GpioPin, mode: GpioMode)

    operator fun invoke(pin: GpioPin) = get(pin) != OFF
}
