package uk.tvidal.kpi.bcm2835

import bcm2835.RPiGPIOPin
import bcm2835.bcm2835FunctionSelect
import bcm2835.bcm2835_gpio_clr
import bcm2835.bcm2835_gpio_fsel
import bcm2835.bcm2835_gpio_lev
import bcm2835.bcm2835_gpio_set
import bcm2835.bcm2835_gpio_write

@ExperimentalUnsignedTypes
object GPIO : PiService() {

    fun mode(pin: RPiGPIOPin, mode: bcm2835FunctionSelect) = bcm2835_gpio_fsel(
        pin = pin.toUByte(),
        mode = mode.toUByte()
    )

    fun on(pin: RPiGPIOPin) = bcm2835_gpio_set(
        pin = pin.toUByte()
    )

    fun off(pin: RPiGPIOPin) = bcm2835_gpio_clr(
        pin = pin.toUByte()
    )

    operator fun set(pin: RPiGPIOPin, value: Boolean) = bcm2835_gpio_write(
        pin = pin.toUByte(),
        on = u(value)
    )

    operator fun get(pin: RPiGPIOPin): Boolean = bcm2835_gpio_lev(pin.toUByte()) != OFF
}
