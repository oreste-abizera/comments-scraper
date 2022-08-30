package rw.oreste.comments.client.dao;

import lombok.Data;

@Data
public class CommentThreadDTO {
private String kind;
    private String etag;
    private String id;
    private CommentThreadSnippetDTO snippet;
}
