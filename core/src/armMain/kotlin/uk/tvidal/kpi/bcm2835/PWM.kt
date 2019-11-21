package uk.tvidal.kpi.bcm2835

import bcm2835.BCM2835_GPIO_FSEL_ALT5
import bcm2835.RPI_GPIO_P1_12
import bcm2835.bcm2835I2CClockDivider
import bcm2835.bcm2835_pwm_set_clock
import bcm2835.bcm2835_pwm_set_data
import bcm2835.bcm2835_pwm_set_mode
import bcm2835.bcm2835_pwm_set_range

@ExperimentalUnsignedTypes
object PWM : PiService() {

    val PWM_PIN = RPI_GPIO_P1_12
    const val PWM_DIVIDER = 32u
    const val PWM_CHANNEL: Byte = 0
    const val PWM_RANGE = 0x400

    fun init(
        divider: bcm2835I2CClockDivider = PWM_DIVIDER,
        range: Int = PWM_RANGE,
        enabled: Boolean = true
    ) {
        if (enabled) {
            GPIO.mode(PWM_PIN, BCM2835_GPIO_FSEL_ALT5)
            clock(divider)
            range(PWM_CHANNEL, range)
        }
        mode(PWM_CHANNEL, 1, enabled)
    }

    fun mode(channel: Byte, markSpace: Byte, enabled: Boolean) = bcm2835_pwm_set_mode(
        channel = u(channel),
        markspace = u(markSpace),
        enabled = u(enabled)
    )

    fun clock(divider: bcm2835I2CClockDivider) = bcm2835_pwm_set_clock(
        divisor = divider
    )

    fun range(channel: Byte, range: Int) = bcm2835_pwm_set_range(
        channel = u(channel),
        range = u(range)
    )

    operator fun invoke(data: Int) =
        set(PWM_CHANNEL, data)

    operator fun set(channel: Byte, data: Int) = bcm2835_pwm_set_data(
        channel = u(channel),
        data = u(data)
    )
}
