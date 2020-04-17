package ro.botolanvlad.APBDOO.data


import ro.botolanvlad.APBDOO.entities.Importance
import ro.botolanvlad.APBDOO.entities.Site
import ro.botolanvlad.APBDOO.models.ImportanceModel
import ro.botolanvlad.APBDOO.models.SiteModel

class SiteData {

    static aSite(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return Site.newInstance(values)
    }

    static aSiteModel(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return SiteModel.newInstance(values)
    }
}
