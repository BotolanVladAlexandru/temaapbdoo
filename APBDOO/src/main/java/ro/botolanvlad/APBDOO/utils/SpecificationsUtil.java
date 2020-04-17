package ro.botolanvlad.APBDOO.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class SpecificationsUtil {
    private SpecificationsUtil() {}


    public static <T> Specification<T> beginsWithIgnoreCase(
            final String field, final String entityFieldName) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get(entityFieldName)),
                        field.toLowerCase() + "%"
                );
    }

    public static <T, V extends Comparable<V>> Specification<T> equalsTo(
            final V field, final String entityFieldName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(entityFieldName), field);
    }


    public static <T, V> Specification<V> getSpecification(final T parameter,
                                                           final SpecificationFunction<T, V> specificationsFunction) {
        if (!StringUtils.isEmpty(parameter)) {
            return specificationsFunction.getSpecification(parameter);
        }
        return null;
    }

    @FunctionalInterface
    public interface SpecificationFunction<T, V> {
        Specification<V> getSpecification(T parameter);
    }
}
