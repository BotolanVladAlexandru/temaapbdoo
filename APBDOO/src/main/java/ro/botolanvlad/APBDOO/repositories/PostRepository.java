package ro.botolanvlad.APBDOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ro.botolanvlad.APBDOO.entities.Post;

public interface PostRepository extends JpaRepository<Post, String>, JpaSpecificationExecutor<Post> {
}
