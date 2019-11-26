package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import uk.tvidal.kpi.gpio.GpioValue.ON
import uk.tvidal.kpi.gpio.GpioValue.TOGGLE
import uk.tvidal.kpi.pwm.PwmService
import wiringpi.wiringPiSetupGpio

actual object Pi : PiService {

    init {
        wiringPiSetupGpio()
    }

    override val pwm: PwmService
        get() = TODO("not implemented")

    override fun on(pin: GpioPin) = pin.on()

    override fun off(pin: GpioPin) = pin.off()

    override fun toggle(pin: GpioPin) = when (pin.read()) {
        ON -> pin.off()
        else -> pin.on()
    }

    override fun get(pin: GpioPin) = pin.read()

    override fun set(pin: GpioPin, value: GpioValue) = when (value) {
        TOGGLE -> toggle(pin)
        ON -> on(pin)
        else -> off(pin)
    }

    override fun set(pin: GpioPin, mode: GpioMode) = pin.setMode(mode)
}
