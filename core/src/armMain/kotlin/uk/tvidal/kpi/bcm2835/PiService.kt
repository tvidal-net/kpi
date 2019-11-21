package uk.tvidal.kpi.bcm2835

import bcm2835.bcm2835_init
import platform.posix.exit

abstract class PiService {

    init {
        // init companion object
        setup()
    }

    companion object {

        init {
            if (bcm2835_init() == 0) {
                println("unable to initialise bcm2835 lib")
                exit(127)
            }
        }

        private fun setup() {}
    }
}
