package ro.botolanvlad.APBDOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.botolanvlad.APBDOO.entities.Importance;
import ro.botolanvlad.APBDOO.entities.Location;

public interface ImportanceRepository extends JpaRepository<Importance, String>{
}
