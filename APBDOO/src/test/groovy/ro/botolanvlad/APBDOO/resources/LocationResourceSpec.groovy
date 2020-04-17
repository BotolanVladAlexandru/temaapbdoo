package ro.botolanvlad.APBDOO.resources

import org.springframework.http.HttpStatus
import ro.botolanvlad.APBDOO.services.ImportanceService
import ro.botolanvlad.APBDOO.services.LocationService
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportanceModel
import static ro.botolanvlad.APBDOO.data.LocationData.aLocationModel

class LocationResourceSpec extends Specification {
    def locationService = Mock(LocationService)

    @Subject
    def resource = new LocationResource(locationService)

    def "Get location"() {
        when:
        def result = resource.getLocations()

        then:
        1 * locationService.getLocations() >> [aLocationModel()]

        and:
        0 * _

        and:
        result.body == [aLocationModel()]
        result.status == HttpStatus.OK
    }
}
