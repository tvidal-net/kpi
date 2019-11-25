package uk.tvidal.kpi

import uk.tvidal.kpi.gpio.GPIO

actual object Pi {

    actual fun on(pin: Pin) = GPIO.on(pin)
}
