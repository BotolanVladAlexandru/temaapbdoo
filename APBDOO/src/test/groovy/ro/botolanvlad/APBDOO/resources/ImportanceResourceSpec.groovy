package ro.botolanvlad.APBDOO.resources

import org.springframework.http.HttpStatus
import ro.botolanvlad.APBDOO.services.ImportanceService
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportanceModel

class ImportanceResourceSpec extends Specification {
    def importanceService = Mock(ImportanceService)

    @Subject
    def resource = new ImportanceResource(importanceService)

    def "Get importance"() {
        when:
        def result = resource.getImportances()

        then:
        1 * importanceService.getImportances() >> [aImportanceModel()]

        and:
        0 * _

        and:
        result.body == [aImportanceModel()]
        result.status == HttpStatus.OK
    }
}
