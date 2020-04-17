package ro.botolanvlad.APBDOO.data

import ro.botolanvlad.APBDOO.models.rest.ErrorModel
import ro.botolanvlad.APBDOO.models.rest.ErrorParameterModel
import ro.botolanvlad.APBDOO.models.rest.RestResponseModel


class RestResponseModelData {

    static RestResponseModel aRestResponseModel(Map overrides = [:]) {
        Map values = [success: true, errors: [aErrorModel()]]
        values << overrides

        new RestResponseModel(values)
    }

    static ErrorModel aErrorModel(Map overrides = [:]) {
        Map values = [message: 'message', params: null]
        values << overrides

        new ErrorModel(values)
    }

    static ErrorParameterModel aErrorParameterModel(Map overrides = [:]) {
        Map values = [name: 'name', value: 'value']
        values << overrides

        new ErrorParameterModel(values)
    }
}
