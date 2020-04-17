package ro.botolanvlad.APBDOO.data

import ro.botolanvlad.APBDOO.models.filter.GenericListModel


class FilterListUtilData {
    static GenericListModel aGenericList(Map overrides = [:]) {
        Map values = [
                items     : [],
                totalCount: 0
        ]
        values << overrides

        new GenericListModel<>(values)
    }
}
