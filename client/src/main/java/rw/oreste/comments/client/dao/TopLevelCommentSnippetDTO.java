package rw.oreste.comments.client.dao;

import lombok.Data;

@Data
public class TopLevelCommentSnippetDTO {
    private String channelId;
    private String videoId;
    private String textDisplay;
    private String textOriginal;
    private String authorDisplayName;
    private String authorProfileImageUrl;
    private String authorChannelUrl;
    private Object authorChannelId;
    private Boolean canRate;
    private String viewerRating;
    private Integer likeCount;
    private String publishedAt;
    private String updatedAt;
}
