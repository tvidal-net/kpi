package uk.tvidal.kpi

import bcm2835.bcm2835_init
import platform.posix.exit
import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import uk.tvidal.kpi.gpio.GpioValue.ON
import uk.tvidal.kpi.gpio.GpioValue.TOGGLE
import uk.tvidal.kpi.pwm.PwmService

actual object Pi : PiService {

    init {
        if (bcm2835_init() == 0) {
            println("unable to initialise bcm2835")
            exit(127)
        }
    }

    override val pwm: PwmService
        get() = PWM

    override fun on(pin: GpioPin) = pin.on()

    override fun off(pin: GpioPin) = pin.off()

    override fun toggle(pin: GpioPin) = when (pin.read()) {
        ON -> pin.off()
        else -> pin.on()
    }

    override operator fun get(pin: GpioPin) = pin.read()

    override operator fun set(pin: GpioPin, value: GpioValue) = when (value) {
        TOGGLE -> toggle(pin)
        ON -> on(pin)
        else -> off(pin)
    }

    override operator fun set(pin: GpioPin, mode: GpioMode) = pin.setMode(mode)
}
