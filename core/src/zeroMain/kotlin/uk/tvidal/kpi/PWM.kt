package uk.tvidal.kpi

import bcm2835.BCM2835_GPIO_FSEL_ALT5
import bcm2835.bcm2835_gpio_fsel
import bcm2835.bcm2835_pwm_set_clock
import bcm2835.bcm2835_pwm_set_data
import bcm2835.bcm2835_pwm_set_mode
import bcm2835.bcm2835_pwm_set_range
import uk.tvidal.kpi.pwm.PwmService
import uk.tvidal.kpi.pwm.PwmService.Companion.PWM_CHANNEL
import uk.tvidal.kpi.pwm.PwmService.Companion.PWM_PIN

object PWM : PwmService {

    override fun start(range: Int, divider: Int) {
        bcm2835_gpio_fsel(PWM_PIN.pin, BCM2835_GPIO_FSEL_ALT5.toUByte())
        setClock(divider)
        setRange(range)
        setMode(true)
    }

    override fun stop() = setMode(false)

    override fun invoke(data: Int) = bcm2835_pwm_set_data(
        channel = u(PWM_CHANNEL),
        data = u(data)
    )

    fun setClock(divider: Int) = bcm2835_pwm_set_clock(
        divisor = u(divider)
    )

    fun setRange(range: Int) = bcm2835_pwm_set_range(
        channel = u(PWM_CHANNEL),
        range = u(range)
    )

    fun setMode(
        enabled: Boolean,
        channel: Byte = PWM_CHANNEL,
        markSpace: Byte = 1
    ) = bcm2835_pwm_set_mode(
        channel = u(channel),
        markspace = u(markSpace),
        enabled = u(enabled)
    )
}
