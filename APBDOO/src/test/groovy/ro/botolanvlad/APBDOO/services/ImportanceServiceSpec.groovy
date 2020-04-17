package ro.botolanvlad.APBDOO.services


import ro.botolanvlad.APBDOO.repositories.ImportanceRepository
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportance
import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportanceModel

class ImportanceServiceSpec extends Specification {
    def importanceRepository = Mock(ImportanceRepository)

    @Subject
    def service = new ImportanceService(importanceRepository)

    def "get importances"(){
        when:
        def result = service.getImportances()

        then:
        1 * importanceRepository.findAll() >> [aImportance()]
        0 * _

        and:
        result == [aImportanceModel()]
    }
}
