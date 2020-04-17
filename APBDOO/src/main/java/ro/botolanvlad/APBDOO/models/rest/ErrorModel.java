package ro.botolanvlad.APBDOO.models.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private String message;
    private List<ErrorParameterModel> params;
}

