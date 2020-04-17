package ro.botolanvlad.APBDOO

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration
class EmbeddedPostgreSQLConfigurationSpecIT extends Specification {

    @Autowired
    ApplicationContext applicationContext

    def "when application context loaded we have an embedded postgres datasource connection"() {

        when:
        def datasource = applicationContext.getBean("datasource")

        then:
        datasource != null
    }

}