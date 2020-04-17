package ro.botolanvlad.APBDOO.resources;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.botolanvlad.APBDOO.models.LocationModel;
import ro.botolanvlad.APBDOO.models.SiteModel;
import ro.botolanvlad.APBDOO.models.User;
import ro.botolanvlad.APBDOO.services.SiteService;

import java.util.List;

@RestController
@RequestMapping("/site")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class SiteResource {

    @NonNull
    private SiteService siteService;

    @GetMapping(produces = "application/json")
    @RequestMapping({"/validateLogin"})
    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @GetMapping
    public ResponseEntity<List<SiteModel>> getSites() {
        log.info("[getSites] Getting sites");
        return ResponseEntity.ok(siteService.getSites());
    }
}
