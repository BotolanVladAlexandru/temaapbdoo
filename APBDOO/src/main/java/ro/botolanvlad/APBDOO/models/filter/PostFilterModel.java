package ro.botolanvlad.APBDOO.models.filter;

import lombok.*;

@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PostFilterModel extends GenericListFilterModel{
    private String title;
    private String text;
    private Boolean deleted;
}
