package uk.tvidal.kpi.pwm

import uk.tvidal.kpi.ansi.AnsiColor.Cyan
import uk.tvidal.kpi.ansi.AnsiColor.Green
import uk.tvidal.kpi.ansi.AnsiColor.Magenta
import uk.tvidal.kpi.ansi.AnsiColor.Yellow
import uk.tvidal.kpi.ansi.AnsiMove.column
import uk.tvidal.kpi.bcm2835.PWM
import uk.tvidal.kpi.bcm2835.PWM.PWM_RANGE
import uk.tvidal.kpi.bcm2835.delay
import kotlin.time.ExperimentalTime

@ExperimentalUnsignedTypes
private val ValidRange = 0 until PWM_RANGE

@ExperimentalUnsignedTypes
private fun pwm(i: Int) {
    print(Green(i))
    print("      ")
    column(8)
    PWM(i)
}

private fun Array<String>.getOrDefault(i: Int, default: Int) =
    if (size <= i) default
    else get(i).toInt()

@ExperimentalTime
@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    val millis = args.getOrDefault(0, 4)
    var step = args.getOrDefault(1, 8)
    var i = 0

    println("range: ${Yellow(PWM_RANGE)}")
    println("delay: ${Cyan(millis)}")
    println("step.: ${Magenta(step)}")
    print("pwm..: ")

    PWM.init()
    while (true) {
        pwm(i)
        delay(millis)
        i += step

        if (i < 0) {
            i = 0
            step = -step
        }
        if (i >= PWM_RANGE) {
            i = PWM_RANGE - 1
            step = -step
        }
    }
}
