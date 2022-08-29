package rw.oreste.comments.client.dao;

import lombok.Data;

@Data
public class SnippetDTO {

    private String title;
    private String description;
    private String channelTitle;
    private String publishedAt;
    private ThumbnailsDTO thumbnails;
    private String channelId;
}
