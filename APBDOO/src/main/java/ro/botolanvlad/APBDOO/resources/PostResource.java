package ro.botolanvlad.APBDOO.resources;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.botolanvlad.APBDOO.models.filter.GenericListModel;
import ro.botolanvlad.APBDOO.models.filter.PostFilterModel;
import ro.botolanvlad.APBDOO.models.PostModel;
import ro.botolanvlad.APBDOO.models.User;
import ro.botolanvlad.APBDOO.models.rest.RestResponseModel;
import ro.botolanvlad.APBDOO.services.MessageService;
import ro.botolanvlad.APBDOO.services.PostService;
import ro.botolanvlad.APBDOO.utils.JsonUtil;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class PostResource {

    @NonNull
    private PostService postService;

    @NonNull
    private final MessageService messageService;

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @PostMapping
    public ResponseEntity<RestResponseModel> createPost(@Valid @RequestBody final PostModel postModel,
                                                        final BindingResult bindingResult) {
        log.info("[createPost] Creating post - " + JsonUtil.toJson(postModel));
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(RestResponseModel
                    .builder()
                    .success(Boolean.FALSE)
                    .errors(messageService.getAllErrors(bindingResult))
                    .build());
        }
        postService.createPost(postModel);
        return ResponseEntity.ok(RestResponseModel
                .builder()
                .success(TRUE)
                .build());
    }


    @PutMapping("/{post_id}")
    public ResponseEntity<RestResponseModel> updatePost(@PathVariable("post_id") @NotNull final String postId,
                                                        @Valid @RequestBody final PostModel postModel,
                                                        final BindingResult bindingResult) {
        log.info("[updatePost] Updating post with id " + postId + " - " + JsonUtil.toJson(postModel));
        postModel.setId(postId);
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(RestResponseModel
                    .builder()
                    .success(Boolean.FALSE)
                    .errors(messageService.getAllErrors(bindingResult))
                    .build());
        }
        postService.updatePost(postModel);
        return ResponseEntity.ok(RestResponseModel
                .builder()
                .success(TRUE)
                .build());
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<PostModel> get(@PathVariable("post_id") final String postId) {
        log.info("[get] Getting post with id " + postId);
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<RestResponseModel> delete(@PathVariable("post_id") final String postId) {
        log.info("[delete] Deleting post with id " + postId);
        postService.deletePost(postId);
        return ResponseEntity.ok(RestResponseModel
                .builder()
                .success(TRUE)
                .build());
    }

    @GetMapping
    public ResponseEntity<GenericListModel<PostModel>> getPosts(
            final @ModelAttribute PostFilterModel genericListFilterModel) {
        log.info("[getPosts] Getting posts with filter - " + JsonUtil.toJson(genericListFilterModel));
        return ResponseEntity.ok(postService.getPosts(genericListFilterModel));
    }
}
