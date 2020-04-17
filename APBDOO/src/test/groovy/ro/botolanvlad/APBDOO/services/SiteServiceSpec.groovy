package ro.botolanvlad.APBDOO.services


import ro.botolanvlad.APBDOO.repositories.SiteRepository
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.SiteData.aSite
import static ro.botolanvlad.APBDOO.data.SiteData.aSiteModel

class SiteServiceSpec extends Specification {
    def siteRepository = Mock(SiteRepository)

    @Subject
    def service = new SiteService(siteRepository)

    def "get sites"() {
        when:
        def result = service.getSites()

        then:
        1 * siteRepository.findAll() >> [aSite()]
        0 * _

        and:
        result == [aSiteModel()]
    }
}
