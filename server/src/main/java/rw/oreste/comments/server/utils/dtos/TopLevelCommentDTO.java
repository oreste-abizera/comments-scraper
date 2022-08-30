package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class TopLevelCommentDTO {
    private String kind;
    private String etag;
    private String id;
    private TopLevelCommentSnippetDTO snippet;
}
