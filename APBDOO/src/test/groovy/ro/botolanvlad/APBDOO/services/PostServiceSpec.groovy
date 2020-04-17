package ro.botolanvlad.APBDOO.services

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import ro.botolanvlad.APBDOO.entities.Post
import ro.botolanvlad.APBDOO.repositories.PostRepository
import ro.botolanvlad.APBDOO.repositories.TagRepository
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static ro.botolanvlad.APBDOO.data.FilterListUtilData.aGenericList
import static ro.botolanvlad.APBDOO.data.PostData.aPost
import static ro.botolanvlad.APBDOO.data.PostData.aPostFilterModel
import static ro.botolanvlad.APBDOO.data.PostData.aPostModel
import static ro.botolanvlad.APBDOO.data.TagData.aTag

class PostServiceSpec extends Specification {
    def postRepository = Mock(PostRepository)
    def tagRepository = Mock(TagRepository)

    @Subject
    def service = new PostService(postRepository, tagRepository)


    def "create post"() {
        when:
        service.createPost(aPostModel())

        then:
        1 * postRepository.save(aPost()) >> aPost()
        0 * _
    }

    def "update post"() {
        when:
        def result = service.updatePost(aPostModel(title: "newTitle"))

        then:
        1 * postRepository.findById("1") >> Optional.of(aPost())
        1 * tagRepository.delete(aTag())
        1 * postRepository.save(aPost(title: "newTitle")) >> aPost(title: "newTitle")
        0 * _

        and:
        result == "1"
    }

    def "get post"() {
        when:
        def result = service.getPost("1")

        then:
        1 * postRepository.findById("1") >> Optional.of(aPost())
        0 * _

        and:
        result == aPostModel()
    }

    @Unroll
    def "delete post"() {
        when:
        service.deletePost("1")

        then:
        1 * postRepository.findById("1") >> post
        nr * postRepository.save(aPost(deleted: true))

        and:
        0 * _

        where:
        nr | post
        1  | Optional.of(aPost())
        0  | Optional.empty()
    }


    def "get posts"(){
        given:
        def pageRequest = PageRequest.of(0, 5, Sort.by("createdAt"))
        def entities = [aPost()]
        def genericList = aGenericList(items: [aPostModel()], totalCount: 1)

        when:
        def result = service.getPosts(aPostFilterModel())

        then:
        1 * postRepository.findAll(_ as org.springframework.data.jpa.domain.Specification<Post>,
                pageRequest) >> new PageImpl<>(entities)
        0 * _

        and:
        result == genericList
    }
}
