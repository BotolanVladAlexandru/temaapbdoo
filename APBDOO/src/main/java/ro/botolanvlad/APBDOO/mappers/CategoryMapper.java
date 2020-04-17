package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Category;
import ro.botolanvlad.APBDOO.models.CategoryModel;

public class CategoryMapper {
    private CategoryMapper() {
    }

    public static Category toEntity(final CategoryModel categoryModel) {
        return Category.builder()
                .id(categoryModel.getId())
                .name(categoryModel.getName())
                .build();
    }

    public static CategoryModel toModel(final Category category) {
        return CategoryModel.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
