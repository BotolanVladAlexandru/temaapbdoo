package ro.botolanvlad.APBDOO.resources

import org.springframework.http.HttpStatus
import ro.botolanvlad.APBDOO.services.SiteService
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.SiteData.aSiteModel

class SiteResourceSpec extends Specification {
    def siteService = Mock(SiteService)

    @Subject
    def resource = new SiteResource(siteService)

    def "Get sites"() {
        when:
        def result = resource.getSites()

        then:
        1 * siteService.getSites() >> [aSiteModel()]

        and:
        0 * _

        and:
        result.body == [aSiteModel()]
        result.status == HttpStatus.OK
    }
}
