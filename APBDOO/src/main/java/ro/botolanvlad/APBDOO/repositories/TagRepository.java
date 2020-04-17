package ro.botolanvlad.APBDOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.botolanvlad.APBDOO.entities.Location;
import ro.botolanvlad.APBDOO.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, String>{
}
