package ro.botolanvlad.APBDOO.data

import ro.botolanvlad.APBDOO.entities.Category
import ro.botolanvlad.APBDOO.entities.Site
import ro.botolanvlad.APBDOO.models.CategoryModel
import ro.botolanvlad.APBDOO.models.SiteModel

class CategoryData {

    static aCategory(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return Category.newInstance(values)
    }

    static aCategoryModel(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return CategoryModel.newInstance(values)
    }
}
