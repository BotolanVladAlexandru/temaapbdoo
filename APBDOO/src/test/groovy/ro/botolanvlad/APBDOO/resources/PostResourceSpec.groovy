package ro.botolanvlad.APBDOO.resources

import org.springframework.http.HttpStatus
import org.springframework.validation.BeanPropertyBindingResult
import ro.botolanvlad.APBDOO.models.PostModel
import ro.botolanvlad.APBDOO.services.MessageService
import ro.botolanvlad.APBDOO.services.PostService
import spock.lang.Specification
import spock.lang.Subject

import static ro.botolanvlad.APBDOO.data.FilterListUtilData.aGenericList
import static ro.botolanvlad.APBDOO.data.PostData.aPostFilterModel
import static ro.botolanvlad.APBDOO.data.PostData.aPostModel
import static ro.botolanvlad.APBDOO.data.RestResponseModelData.aErrorModel
import static ro.botolanvlad.APBDOO.data.RestResponseModelData.aRestResponseModel

class PostResourceSpec extends Specification {
    def postService = Mock(PostService)
    def messageService = Mock(MessageService)


    @Subject
    def resource = new PostResource(postService, messageService)

    def "Get posts"() {
        given:
        def filters = aPostFilterModel()
        def items = aGenericList(items: [aPostModel()])
        when:
        def result = resource.getPosts(filters)

        then:
        1 * postService.getPosts(filters) >> items

        and:
        0 * _

        and:
        result.body == items
        result.status == HttpStatus.OK
    }

    def "Create post"() {
        given:
        def bindingResult = new BeanPropertyBindingResult(new PostModel(), "postModel")

        when:
        def result = resource.createPost(aPostModel(), bindingResult)

        then:
        1 * postService.createPost(aPostModel())
        0 * _

        and:
        result.statusCode == HttpStatus.OK
        result.body == aRestResponseModel(success: true, errors: null)
    }


    def "Create post with error"() {
        given:
        def bindingResult = new BeanPropertyBindingResult(new PostModel(), "postModel")
        bindingResult.reject("error")

        when:
        def result = resource.createPost(aPostModel(title: null), bindingResult)

        then:
        1 * messageService.getAllErrors(bindingResult) >> [aErrorModel()]
        0 * _

        and:
        result.statusCode == HttpStatus.BAD_REQUEST
        result.body == aRestResponseModel(success: false, errors: [aErrorModel()])
    }

    def "Update post"() {
        given:
        def bindingResult = new BeanPropertyBindingResult(new PostModel(), "postModel")

        when:
        def result = resource.updatePost("1", aPostModel(), bindingResult)

        then:
        1 * postService.updatePost(aPostModel())
        0 * _

        and:
        result.statusCode == HttpStatus.OK
        result.body == aRestResponseModel(success: true, errors: null)
    }

    def "Get post"() {
        given:
        def id = "1"

        when:
        def result = resource.get(id)

        then:
        1 * postService.getPost(id) >> aPostModel()
        0 * _

        and:
        result.statusCode == HttpStatus.OK
        result.body == aPostModel()
    }

    def "Delete post"() {
        given:
        def id = "1"

        when:
        def result = resource.delete(id)

        then:
        1 * postService.deletePost(id)
        0 * _

        and:
        result.statusCode == HttpStatus.OK
        result.body == aRestResponseModel(success: true, errors: null)
    }
}
