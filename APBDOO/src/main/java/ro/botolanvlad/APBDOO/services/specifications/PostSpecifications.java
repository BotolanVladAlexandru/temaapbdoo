package ro.botolanvlad.APBDOO.services.specifications;

import org.springframework.data.jpa.domain.Specification;
import ro.botolanvlad.APBDOO.entities.Post;
import ro.botolanvlad.APBDOO.models.filter.PostFilterModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ro.botolanvlad.APBDOO.utils.SpecificationsUtil.*;

public class PostSpecifications {
    private PostSpecifications() {
    }

    public static Specification<Post> getPostSpec(
            final PostFilterModel postFilterModel) {
        final List<Specification<Post>> specifications = new ArrayList<>();

        specifications.add(getSpecification(
                postFilterModel.getTitle(), fieldValue -> beginsWithIgnoreCase(fieldValue, "title")
        ));

        specifications.add(getSpecification(
                postFilterModel.getText(), fieldValue -> beginsWithIgnoreCase(fieldValue, "text")
        ));

        specifications.add(getSpecification(
                postFilterModel.getDeleted(), fieldValue -> equalsTo(fieldValue, "deleted")
        ));

        return specifications.stream()
                .filter(obj -> !Objects.isNull(obj))
                .map(Specification::where)
                .reduce(Specification.where(null), Specification::and);
    }
}
