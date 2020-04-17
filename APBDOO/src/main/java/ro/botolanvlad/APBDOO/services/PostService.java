package ro.botolanvlad.APBDOO.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.botolanvlad.APBDOO.entities.Post;
import ro.botolanvlad.APBDOO.exceptions.PostNotFoundException;
import ro.botolanvlad.APBDOO.mappers.PostMapper;
import ro.botolanvlad.APBDOO.models.PostModel;
import ro.botolanvlad.APBDOO.models.filter.GenericListModel;
import ro.botolanvlad.APBDOO.models.filter.PostFilterModel;
import ro.botolanvlad.APBDOO.repositories.PostRepository;
import ro.botolanvlad.APBDOO.repositories.TagRepository;
import ro.botolanvlad.APBDOO.services.specifications.PostSpecifications;
import ro.botolanvlad.APBDOO.utils.SortUtil;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    @NonNull
    private PostRepository postRepository;

    @NonNull
    private TagRepository tagRepository;

    public void createPost(final PostModel postModel) {
        Post post = PostMapper.toEntity(postModel);
        postRepository.save(post);
    }

    public String updatePost(final PostModel postModel) {
        return postRepository.findById(postModel.getId())
                .map(post -> {
                    final Post postToSave = PostMapper.toEntity(postModel);
                    tagRepository.delete(post.getTag());
                    postRepository.save(postToSave);
                    return post.getId();
                })
                .orElseThrow(() -> new PostNotFoundException(postModel.getId()));
    }

    public PostModel getPost(final String postId) {
        return postRepository
                .findById(postId)
                .map(PostMapper::toModel)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    public void deletePost(final String postId) {
        postRepository.findById(postId)
                .ifPresent(post -> {
                    post.setDeleted(true);
                    postRepository.save(post);
                });
    }

    @Transactional(readOnly = true)
    public GenericListModel<PostModel> getPosts(final PostFilterModel postFilterModel) {
        final Page<Post> posts = getFilteredPostsEntities(postFilterModel);
        return GenericListModel.fromPage(posts.map(PostMapper::toModel));
    }

    private Page<Post> getFilteredPostsEntities(final PostFilterModel postFilterModel) {
        postFilterModel.setDeleted(false);
        return SortUtil.getCurrentOrLastPage(postRepository,
                PostSpecifications.getPostSpec(postFilterModel),
                postFilterModel.toPageRequest());
    }
}
