# K-Pi

A kotlin native library for the raspberry-pi.

This project is in a very early development stage, but I'm uploading
it to github, to help other people who are, like I was a few days
ago, looking for a kotlin native lib for the raspberry-pi.

As of now, this library is just a wrapper around the C Library
for the Broadcom
[BCM 2835](https://www.airspayce.com/mikem/bcm2835/index.html),
created by [Mike McCauley](mailto:mikem@airspayce.com).

Is has been tested on a raspberry-pi zero.

To build for the `linuxArm32Hfp` target, a linux
development environment is needed. I am using Debian Buster Desktop
Workstation to compile it.

## Usage

Apart from the library's [core](core/) module, I'm creating
an executable module for each supported raspberry-pi feature.

GPIO is the only feature that doesn't require root. To work
around this limitation, I usually set the suid as soon as
the executable is uploaded to the raspberry pi.

# Modules

- [GPIO](#GPIO)
- [PWM](#PWM)
- [SPI](#SPI)
- [I2C](#I2C)

### PWM

- [Main.kt](pwm/src/armMain/kotlin/uk/tvidal/kpi/pwm/Main.kt)

Example:

```kotlin
import uk.tvidal.kpi.bcm2835.PWM
import uk.tvidal.kpi.bcm2835.PWM.PWM_RANGE
import uk.tvidal.kpi.bcm2835.delay
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalUnsignedTypes
fun main() {
    // enabled the PWM interface
    // using default settings
    PWM.init()
    for (i in 0 until PWM_RANGE) {
        PWM(i)
        delay(2)
    }
}
```

```bash
scp -C 'pwm/build/bin/arm/debugExecutable/pwm.kexe' 'pi@192.168.0.xxx:~'
ssh 'pi@192.168.0.xxx' 'sudo bash -' <<EOF
chown root:pi 'pwm.kexe'
chmod 04775 'pwm.kexe'
./pwm.kexe
EOF
```

## Road Map

1. GPIO module
1. Command-Line Argument Parser
1. Support for SPI and I2C interfaces
1. Alternative implementation wrapping the [WiringPi](http://wiringpi.com/) lib
1. Support the BCM 2836 and BCM 2837 chipsets through a common interface
1. Better automated testing
1. Benchmark comparison of multiple implementations
