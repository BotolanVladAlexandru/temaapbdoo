package ro.botolanvlad.APBDOO.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Post extends AbstractAuditable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @NonNull
    private Boolean deleted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    private Set<Category> categories;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Importance importance;

    @ManyToMany
    @JoinTable(
            name = "post_site",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "site_id"))
    private Set<Site> sites;
}
