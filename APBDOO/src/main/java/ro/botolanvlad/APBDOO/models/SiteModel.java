package ro.botolanvlad.APBDOO.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteModel {

    private String id;

    @NotNull
    private String name;
}
