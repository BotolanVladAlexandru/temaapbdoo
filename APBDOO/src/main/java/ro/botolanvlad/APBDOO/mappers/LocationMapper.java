package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Location;
import ro.botolanvlad.APBDOO.models.LocationModel;

public class LocationMapper {
    private LocationMapper() {
    }

    public static Location toEntity(final LocationModel locationModel) {
        return Location.builder()
                .id(locationModel.getId())
                .name(locationModel.getName())
                .build();
    }

    public static LocationModel toModel(final Location location) {
        return LocationModel.builder()
                .id(location.getId())
                .name(location.getName())
                .build();
    }
}
