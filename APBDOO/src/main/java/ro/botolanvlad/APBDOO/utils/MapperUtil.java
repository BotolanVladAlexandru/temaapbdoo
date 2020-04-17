package ro.botolanvlad.APBDOO.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class MapperUtil {

    private MapperUtil() {} //NOSONAR

    public static <T, V> Set<V> mapToSet(
            final Collection<T> setOfModels,
            final Function<T, V> mapper) {
        return Optional
                .ofNullable(setOfModels)
                .orElse(Collections.emptySet())
                .stream()
                .map(mapper)
                .collect(Collectors.toSet());
    }

    public static <T, V> List<V> mapToList(
            final Collection<T> setOfModels,
            final Function<T, V> mapper) {
        return Optional
                .ofNullable(setOfModels)
                .orElse(Collections.emptySet())
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

}
