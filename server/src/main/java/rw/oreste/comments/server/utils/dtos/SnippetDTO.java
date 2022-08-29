package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class SnippetDTO {

    private String title;
    private String description;
    private String channelTitle;
    private String publishedAt;
    private Object thumbnails;
    private String channelId;
}
