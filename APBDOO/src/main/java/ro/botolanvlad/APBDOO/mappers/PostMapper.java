package ro.botolanvlad.APBDOO.mappers;

import ro.botolanvlad.APBDOO.entities.Post;
import ro.botolanvlad.APBDOO.models.PostModel;

import static ro.botolanvlad.APBDOO.utils.MapperUtil.mapToList;
import static ro.botolanvlad.APBDOO.utils.MapperUtil.mapToSet;

public class PostMapper {
    private PostMapper() {
    }

    public static Post toEntity(final PostModel postModel) {
        return Post.builder()
                .id(postModel.getId())
                .text(postModel.getText())
                .title(postModel.getTitle())
                .deleted(false)
                .location(LocationMapper.toEntity(postModel.getLocationModel()))
                .importance(ImportanceMapper.toEntity(postModel.getImportanceModel()))
                .tag(TagMapper.toEntity(postModel.getTagModel()))
                .categories(mapToSet(postModel.getCategoryModels(), CategoryMapper::toEntity))
                .sites(mapToSet(postModel.getSiteModels(), SiteMapper::toEntity))
                .build();
    }

    public static PostModel toModel(final Post post) {
        return PostModel.builder()
                .id(post.getId())
                .text(post.getText())
                .title(post.getTitle())
                .locationModel(LocationMapper.toModel(post.getLocation()))
                .importanceModel(ImportanceMapper.toModel(post.getImportance()))
                .tagModel(TagMapper.toModel(post.getTag()))
                .categoryModels(mapToList(post.getCategories(), CategoryMapper::toModel))
                .siteModels(mapToList(post.getSites(), SiteMapper::toModel))
                .build();
    }


}
