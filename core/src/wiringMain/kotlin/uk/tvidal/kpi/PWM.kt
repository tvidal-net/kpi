package uk.tvidal.kpi

import uk.tvidal.kpi.pwm.PwmService
import uk.tvidal.kpi.pwm.PwmService.Companion.PWM_PIN
import wiringpi.PWM_MODE_MS
import wiringpi.PWM_OUTPUT
import wiringpi.pinMode
import wiringpi.pwmSetClock
import wiringpi.pwmSetMode
import wiringpi.pwmSetRange
import wiringpi.pwmWrite

object PWM : PwmService {

    override fun start(range: Int, divider: Int) {
        pinMode(PWM_PIN.pin.toInt(), PWM_OUTPUT)
        pwmSetMode(PWM_MODE_MS)
        pwmSetClock(divider)
        pwmSetRange(range.toUInt())
    }

    override fun stop() {
    }

    override fun invoke(data: Int) {
        pwmWrite(PWM_PIN.pin.toInt(), data)
    }
}
