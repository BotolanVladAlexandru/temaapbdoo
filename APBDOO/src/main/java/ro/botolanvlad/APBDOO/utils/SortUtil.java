package ro.botolanvlad.APBDOO.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortUtil {
    private SortUtil() {
    } //NOSONAR

    public static Sort getSortOrderList(String sort) {
        String[] orderElements = sort.split(",");
        List<Sort.Order> orderList = IntStream.range(0, orderElements.length - 1)
                        .filter(i -> i % 2 == 0)
                        .mapToObj(i -> new Sort.Order(Sort.Direction.fromString(orderElements[i + 1].trim()), orderElements[i].trim()))
                        .collect(Collectors.toList());

        if(orderList.stream().noneMatch(s -> "createdAt".equals(s.getProperty()))) {
            orderList.add(new Sort.Order(Sort.Direction.ASC, "createdAt"));
        }

        return Sort.by(orderList);
    }

    public static <T> Page<T> getCurrentOrLastPage(JpaSpecificationExecutor<T> repo, Specification<T> spec, Pageable pageable) {
        Page<T> all = repo.findAll(spec, pageable);
        boolean currentPageHasContentOrThereIsNoContentAtAll = all.getTotalPages() == 0 || all.hasContent();
        if (currentPageHasContentOrThereIsNoContentAtAll) {
            return all;
        } else {
            return repo.findAll(spec, PageRequest.of(all.getTotalPages() -1, pageable.getPageSize() , pageable.getSort()));
        }
    }
}
