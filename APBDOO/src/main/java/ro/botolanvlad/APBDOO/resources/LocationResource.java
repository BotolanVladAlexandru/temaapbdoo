package ro.botolanvlad.APBDOO.resources;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.botolanvlad.APBDOO.models.LocationModel;
import ro.botolanvlad.APBDOO.models.PostModel;
import ro.botolanvlad.APBDOO.models.User;
import ro.botolanvlad.APBDOO.models.filter.GenericListModel;
import ro.botolanvlad.APBDOO.models.filter.PostFilterModel;
import ro.botolanvlad.APBDOO.models.rest.RestResponseModel;
import ro.botolanvlad.APBDOO.services.LocationService;
import ro.botolanvlad.APBDOO.services.MessageService;
import ro.botolanvlad.APBDOO.services.PostService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class LocationResource {

    @NonNull
    private LocationService locationService;

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @GetMapping
    public ResponseEntity<List<LocationModel>> getLocations() {
        log.info("[getLocations] Getting locations");
        return ResponseEntity.ok(locationService.getLocations());
    }
}
