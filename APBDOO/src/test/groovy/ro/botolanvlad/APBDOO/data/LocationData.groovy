package ro.botolanvlad.APBDOO.data


import ro.botolanvlad.APBDOO.entities.Importance
import ro.botolanvlad.APBDOO.entities.Location
import ro.botolanvlad.APBDOO.models.ImportanceModel
import ro.botolanvlad.APBDOO.models.LocationModel

class LocationData {

    static aLocation(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return Location.newInstance(values)
    }

    static aLocationModel(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return LocationModel.newInstance(values)
    }
}
