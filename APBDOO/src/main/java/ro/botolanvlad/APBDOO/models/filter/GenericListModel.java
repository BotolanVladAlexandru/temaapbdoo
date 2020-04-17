package ro.botolanvlad.APBDOO.models.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericListModel<T> {
    private List<T> items;
    private Long totalCount;

    public static <T> GenericListModel<T> fromPage(final Page<T> page) {
        return new GenericListModel<>(page.getContent(), page.getTotalElements());
    }
}
