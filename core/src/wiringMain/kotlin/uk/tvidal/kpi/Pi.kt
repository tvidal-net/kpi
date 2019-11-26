package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GpioMode
import uk.tvidal.kpi.gpio.GpioValue
import uk.tvidal.kpi.pwm.PwmService

actual object Pi : PiService {

    override val pwm: PwmService
        get() = TODO("not implemented")

    override fun on(pin: GpioPin) {
        TODO("not implemented")
    }

    override fun off(pin: GpioPin) {
        TODO("not implemented")
    }

    override fun toggle(pin: GpioPin) {
        TODO("not implemented")
    }

    override fun get(pin: GpioPin): GpioValue {
        TODO("not implemented")
    }

    override fun set(pin: GpioPin, value: GpioValue) {
        TODO("not implemented")
    }

    override fun set(pin: GpioPin, mode: GpioMode) {
        TODO("not implemented")
    }
}
