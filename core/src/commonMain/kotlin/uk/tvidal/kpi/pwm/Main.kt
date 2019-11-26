package uk.tvidal.kpi.pwm

import uk.tvidal.kpi.Pi.pwm

fun main(args: Array<String>) {
    val data = if (args.isEmpty()) 0 else args[0].toInt()
    pwm.start()
    pwm(data)
}
