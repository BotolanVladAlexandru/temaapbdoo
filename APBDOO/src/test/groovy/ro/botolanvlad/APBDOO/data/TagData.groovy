package ro.botolanvlad.APBDOO.data


import ro.botolanvlad.APBDOO.entities.Site
import ro.botolanvlad.APBDOO.entities.Tag
import ro.botolanvlad.APBDOO.models.SiteModel
import ro.botolanvlad.APBDOO.models.TagModel

class TagData {

    static aTag(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return Tag.newInstance(values)
    }

    static aTagModel(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return TagModel.newInstance(values)
    }
}
