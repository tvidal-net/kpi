package uk.tvidal.kpi.pwm

import uk.tvidal.kpi.GpioPin

interface PwmService {

    fun start(range: Int = PWM_RANGE, divider: Int = PWM_DIVIDER)

    fun stop()

    operator fun invoke(data: Int)

    companion object {
        val PWM_PIN = GpioPin.P1_12
        const val PWM_DIVIDER = 32
        const val PWM_CHANNEL: Byte = 0
        const val PWM_RANGE = 0x400
    }
}
