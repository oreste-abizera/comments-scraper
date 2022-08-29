package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class ChannelDTO {
    private String kind;
    private String etag;
    private Object id;
    private SnippetDTO snippet;
}
