package ro.botolanvlad.APBDOO.services


import ro.botolanvlad.APBDOO.repositories.LocationRepository
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.LocationData.aLocation
import static ro.botolanvlad.APBDOO.data.LocationData.aLocationModel

class LocationServiceSpec extends Specification {
    def locationRepository = Mock(LocationRepository)

    @Subject
    def service = new LocationService(locationRepository)
    
    def "get locations"(){
        when:
        def result = service.getLocations()

        then:
        1 * locationRepository.findAll() >> [aLocation()]
        0 * _

        and:
        result == [aLocationModel()]
    }
}
