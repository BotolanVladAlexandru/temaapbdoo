package ro.botolanvlad.APBDOO.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String text;

    private TagModel tagModel;

    private List<CategoryModel> categoryModels;

    private LocationModel locationModel;

    private ImportanceModel importanceModel;

    private List<SiteModel> siteModels;
}
