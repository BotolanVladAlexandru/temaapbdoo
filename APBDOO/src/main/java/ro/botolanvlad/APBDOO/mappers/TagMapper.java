package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Tag;
import ro.botolanvlad.APBDOO.models.TagModel;

public class TagMapper {
    private TagMapper() {
    }

    public static Tag toEntity(final TagModel tagModel) {
        return Tag.builder()
                .id(tagModel.getId())
                .name(tagModel.getName())
                .build();
    }

    public static TagModel toModel(final Tag tag) {
        return TagModel.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
