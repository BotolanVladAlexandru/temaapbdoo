package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Site;
import ro.botolanvlad.APBDOO.models.SiteModel;

public class SiteMapper {
    private SiteMapper() {
    }

    public static Site toEntity(final SiteModel siteModel) {
        return Site.builder()
                .id(siteModel.getId())
                .name(siteModel.getName())
                .build();
    }

    public static SiteModel toModel(final Site site) {
        return SiteModel.builder()
                .id(site.getId())
                .name(site.getName())
                .build();
    }
}
