package ro.botolanvlad.APBDOO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.botolanvlad.APBDOO.entities.Site;
import ro.botolanvlad.APBDOO.entities.Tag;

public interface SiteRepository extends JpaRepository<Site, String>{
}
