package rw.oreste.comments.client.dao;

import lombok.Data;

@Data
public class TopLevelCommentDTO {
    private String kind;
    private String etag;
    private String id;
    private TopLevelCommentSnippetDTO snippet;
}
