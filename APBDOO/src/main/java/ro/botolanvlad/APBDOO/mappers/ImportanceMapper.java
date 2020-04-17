package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Importance;
import ro.botolanvlad.APBDOO.entities.Location;
import ro.botolanvlad.APBDOO.models.ImportanceModel;
import ro.botolanvlad.APBDOO.models.LocationModel;

public class ImportanceMapper {
    private ImportanceMapper() {
    }

    public static Importance toEntity(final ImportanceModel importanceModel) {
        return Importance.builder()
                .id(importanceModel.getId())
                .name(importanceModel.getName())
                .build();
    }

    public static ImportanceModel toModel(final Importance importance) {
        return ImportanceModel.builder()
                .id(importance.getId())
                .name(importance.getName())
                .build();
    }
}
