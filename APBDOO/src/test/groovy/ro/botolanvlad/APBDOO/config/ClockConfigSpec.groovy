package ro.botolanvlad.APBDOO.config

import ro.botolanvlad.APBDOO.configs.ClockConfig
import spock.lang.Specification

import java.time.Clock


class ClockConfigSpec extends Specification {
    def config = new ClockConfig()

    def "Generate clock"() {
        when:
        def clock = config.getClock()

        then:
        clock == Clock.systemUTC()
    }

    def "Check timezone"() {
        when:
        config.init()

        then:
        Calendar.getInstance().getTimeZone() == TimeZone.getTimeZone("UTC")
    }
}