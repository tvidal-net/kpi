package uk.tvidal.kpi.gpio

import uk.tvidal.kpi.bcm2835.GPIO
import uk.tvidal.kpi.getOrDefault
import uk.tvidal.kpi.u

private fun printHelp() {
    println(
        """Usage: gpio.kexe <cmd> [pin]
- Where <cmd> is one of:
      in <pin>       configures <pin> as INPUT
     out <pin>       configures <pin> as OUTPUT
      on <pin>       changes output of <pin> to HIGH
     off <pin>       changes output of <pin> to LOW
    read <pin>       prints HIGH/LOW
  toggle <pin>       reverses the state
"""
    )
}

private val Array<String>.cmd: String
    get() = get(0).toLowerCase()

@ExperimentalUnsignedTypes
private val Array<String>.pin: UInt
    get() = u(getOrDefault(1, 18))

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    if (args.isEmpty()) printHelp() else when (args.cmd) {
        "on" -> GPIO.on(args.pin)
        "off" -> GPIO.off(args.pin)
        "in" -> GPIO.input(args.pin)
        "out" -> GPIO.output(args.pin)
        "read" -> println(if (GPIO[args.pin]) "HIGH" else "LOW")
        "toggle" -> args.pin.let {
            if (GPIO[it]) GPIO.off(it)
            else GPIO.on(it)
        }
        else -> printHelp()
    }
}
