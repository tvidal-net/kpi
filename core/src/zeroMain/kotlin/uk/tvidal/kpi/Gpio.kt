package uk.tvidal.kpi

import bcm2835.BCM2835_GPIO_FSEL_INPT
import bcm2835.BCM2835_GPIO_FSEL_OUTP
import bcm2835.LOW
import bcm2835.bcm2835_gpio_clr
import bcm2835.bcm2835_gpio_fsel
import bcm2835.bcm2835_gpio_lev
import bcm2835.bcm2835_gpio_set
import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioMode.INPUT
import uk.tvidal.kpi.gpio.GpioMode.OUTPUT
import uk.tvidal.kpi.gpio.GpioValue.OFF
import uk.tvidal.kpi.gpio.GpioValue.ON

fun GpioPin.on() = bcm2835_gpio_set(pin.toUByte())
fun GpioPin.off() = bcm2835_gpio_clr(pin.toUByte())

fun GpioPin.read() = when (bcm2835_gpio_lev(pin.toUByte())) {
    LOW.toUByte() -> OFF
    else -> ON
}

fun GpioPin.setMode(mode: GpioMode) = when (mode) {
    INPUT -> bcm2835_gpio_fsel(pin.toUByte(), BCM2835_GPIO_FSEL_INPT.toUByte())
    OUTPUT -> bcm2835_gpio_fsel(pin.toUByte(), BCM2835_GPIO_FSEL_OUTP.toUByte())
}
