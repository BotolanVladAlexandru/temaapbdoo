package ro.botolanvlad.APBDOO.IT.resources

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.web.client.RestTemplate
import ro.botolanvlad.APBDOO.models.SiteModel
import ro.botolanvlad.APBDOO.models.filter.GenericListModel
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD
import static ro.botolanvlad.APBDOO.data.FilterListUtilData.aGenericList

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration
@SqlGroup(value = [
        @Sql(value = ["/sql/data.sql"], executionPhase = BEFORE_TEST_METHOD),
        @Sql(value = ["/sql/delete_all.sql"], executionPhase = AFTER_TEST_METHOD),
])
class SiteResourceSpecIT extends Specification{
    static String SITE_URL = "/site"

    @Autowired
    TestRestTemplate restTemplate

    @Unroll
    def "Get sites"() {
        when:
        def responseEntity = restTemplate.exchange(SITE_URL , HttpMethod.GET,
                null, new ParameterizedTypeReference<GenericListModel<SiteModel>>() {
        })

        then:
        responseEntity.statusCode == HttpStatus.OK
        responseEntity.body == aGenericList(items: [], totalCount: 0)                                                                                  || [aErrorModel(message: "clientEmails[] must be a well-formed email address")]
    }

}
