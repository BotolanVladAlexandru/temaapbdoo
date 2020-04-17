package ro.botolanvlad.APBDOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.botolanvlad.APBDOO.entities.Category;
import ro.botolanvlad.APBDOO.entities.Tag;

public interface CategoryRepository extends JpaRepository<Category, String>{
}
