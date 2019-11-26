package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import wiringpi.HIGH
import wiringpi.INPUT
import wiringpi.LOW
import wiringpi.OUTPUT
import wiringpi.digitalRead
import wiringpi.digitalWrite
import wiringpi.pinMode

fun GpioPin.on() = digitalWrite(pin.toInt(), HIGH)
fun GpioPin.off() = digitalWrite(pin.toInt(), LOW)

fun GpioPin.read() = when (digitalRead(pin.toInt())) {
    LOW -> GpioValue.OFF
    else -> GpioValue.ON
}

fun GpioPin.setMode(mode: GpioMode) = when (mode) {
    GpioMode.INPUT -> pinMode(pin.toInt(), INPUT)
    GpioMode.OUTPUT -> pinMode(pin.toInt(), OUTPUT)
}
