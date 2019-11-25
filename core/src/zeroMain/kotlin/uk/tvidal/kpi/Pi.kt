package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import uk.tvidal.kpi.gpio.GpioValue.OFF
import uk.tvidal.kpi.gpio.GpioValue.ON
import uk.tvidal.kpi.gpio.GpioValue.TOGGLE

actual object Pi {

    actual fun on(pin: GpioPin) = pin.on()

    actual fun off(pin: GpioPin) = pin.off()

    actual fun toggle(pin: GpioPin) = when (pin.read()) {
        ON -> pin.off()
        else -> pin.on()
    }

    actual operator fun get(pin: GpioPin) = pin.read()

    actual operator fun set(pin: GpioPin, value: GpioValue) = when (value) {
        TOGGLE -> toggle(pin)
        ON -> on(pin)
        else -> off(pin)
    }

    actual operator fun set(pin: GpioPin, mode: GpioMode) = pin.setMode(mode)

    actual operator fun invoke(pin: GpioPin) = pin.read() != OFF
}
