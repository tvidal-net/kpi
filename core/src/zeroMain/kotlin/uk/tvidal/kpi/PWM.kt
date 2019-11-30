package uk.tvidal.kpi

import bcm2835.BCM2835_GPIO_FSEL_ALT5
import bcm2835.bcm2835_gpio_fsel
import bcm2835.bcm2835_pwm_set_clock
import bcm2835.bcm2835_pwm_set_data
import bcm2835.bcm2835_pwm_set_mode
import bcm2835.bcm2835_pwm_set_range
import kotlinx.cinterop.toByte
import uk.tvidal.kpi.pwm.PwmService
import uk.tvidal.kpi.pwm.PwmService.Companion.PWM_CHANNEL
import uk.tvidal.kpi.pwm.PwmService.Companion.PWM_PIN

object PWM : PwmService {

    override fun start(range: Int, divider: Int) {
        bcm2835_gpio_fsel(PWM_PIN.pin.toUByte(), BCM2835_GPIO_FSEL_ALT5.toUByte())
        setClock(divider)
        setRange(range)
        setMode(true)
    }

    override fun stop() = setMode(false)

    override fun invoke(data: Int) = bcm2835_pwm_set_data(
        channel = PWM_CHANNEL.toUByte(),
        data = data.toUInt()
    )

    fun setClock(divider: Int) = bcm2835_pwm_set_clock(
        divisor = divider.toUInt()
    )

    fun setRange(range: Int) = bcm2835_pwm_set_range(
        channel = PWM_CHANNEL.toUByte(),
        range = range.toUInt()
    )

    fun setMode(
        enabled: Boolean,
        channel: Byte = PWM_CHANNEL,
        markSpace: Byte = 1
    ) = bcm2835_pwm_set_mode(
        channel = channel.toUByte(),
        markspace = markSpace.toUByte(),
        enabled = enabled.toByte().toUByte()
    )
}
