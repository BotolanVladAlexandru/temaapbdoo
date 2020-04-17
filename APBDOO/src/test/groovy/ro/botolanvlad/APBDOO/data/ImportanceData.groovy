package ro.botolanvlad.APBDOO.data


import ro.botolanvlad.APBDOO.entities.Importance
import ro.botolanvlad.APBDOO.models.ImportanceModel

class ImportanceData {

    static aImportance(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return Importance.newInstance(values)
    }

    static aImportanceModel(Map overrides = [:]) {
        Map values = [
                id  : '1',
                name: "High"
        ]
        values << overrides
        return ImportanceModel.newInstance(values)
    }
}
