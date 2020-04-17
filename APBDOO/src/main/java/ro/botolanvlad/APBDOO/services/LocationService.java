package ro.botolanvlad.APBDOO.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.botolanvlad.APBDOO.mappers.LocationMapper;
import ro.botolanvlad.APBDOO.models.LocationModel;
import ro.botolanvlad.APBDOO.repositories.LocationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LocationService {

    @NonNull
    private LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public List<LocationModel> getLocations() {
        return locationRepository.findAll().stream()
                .map(LocationMapper::toModel)
                .collect(Collectors.toList());
    }
}
