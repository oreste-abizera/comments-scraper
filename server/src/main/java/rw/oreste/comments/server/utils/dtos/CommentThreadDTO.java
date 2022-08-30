package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class CommentThreadDTO {
private String kind;
    private String etag;
    private String id;
    private SnippetDTO snippet;
}
