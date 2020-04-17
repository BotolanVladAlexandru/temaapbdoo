package ro.botolanvlad.APBDOO.data

import ro.botolanvlad.APBDOO.entities.Post
import ro.botolanvlad.APBDOO.entities.Site
import ro.botolanvlad.APBDOO.models.PostModel
import ro.botolanvlad.APBDOO.models.SiteModel
import ro.botolanvlad.APBDOO.models.filter.PostFilterModel

import static ro.botolanvlad.APBDOO.data.CategoryData.aCategory
import static ro.botolanvlad.APBDOO.data.CategoryData.aCategoryModel
import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportance
import static ro.botolanvlad.APBDOO.data.ImportanceData.aImportanceModel
import static ro.botolanvlad.APBDOO.data.LocationData.aLocation
import static ro.botolanvlad.APBDOO.data.LocationData.aLocationModel
import static ro.botolanvlad.APBDOO.data.SiteData.aSite
import static ro.botolanvlad.APBDOO.data.SiteData.aSiteModel
import static ro.botolanvlad.APBDOO.data.TagData.aTag
import static ro.botolanvlad.APBDOO.data.TagData.aTagModel

class PostData {

    static aPost(Map overrides = [:]) {
        Map values = [
                id        : '1',
                title     : "Title",
                text      : "Text",
                deleted   : false,
                tag       : aTag(),
                categories: [aCategory()].toSet(),
                location  : aLocation(),
                importance: aImportance(),
                sites     : [aSite()].toSet()
        ]
        values << overrides
        return Post.newInstance(values)
    }

    static aPostFilterModel(Map overrides = [:]) {
        Map values = [
                title     : null,
                text      : null,
                deleted   : false,
        ]
        values << overrides
        return PostFilterModel.newInstance(values)
    }

    static aPostModel(Map overrides = [:]) {
        Map values = [
                id             : '1',
                title          : "Title",
                text           : "Text",
                tagModel       : aTagModel(),
                categoryModels : [aCategoryModel()],
                locationModel  : aLocationModel(),
                importanceModel: aImportanceModel(),
                siteModels     : [aSiteModel()]
        ]
        values << overrides
        return PostModel.newInstance(values)
    }
}
