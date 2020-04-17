package ro.botolanvlad.APBDOO.models.filter;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import ro.botolanvlad.APBDOO.utils.SortUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericListFilterModel {

    private static final Integer PAGE_SIZE_FIVE = 5;
    private static final Integer FIRST_PAGE = 0;
    private static final String SORT_EMPTY = "";
    private Boolean exportAll = Boolean.FALSE;

    private Integer page = FIRST_PAGE;
    private Integer size = PAGE_SIZE_FIVE;
    private String sort = SORT_EMPTY;

    public Integer getPage() {
        return exportAll ? 0 : page;
    }

    public Integer getSize() {
        if (exportAll) {
            return Integer.MAX_VALUE;
        }
        return size > 0 ? size : PAGE_SIZE_FIVE;
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(getPage(), getSize(), SortUtil.getSortOrderList(getSort()));
    }
}
