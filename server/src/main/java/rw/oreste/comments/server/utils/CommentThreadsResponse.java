package rw.oreste.comments.server.utils;

import lombok.Data;
import rw.oreste.comments.server.utils.dtos.CommentThreadDTO;

@Data
public class CommentThreadsResponse {
    private String kind;
    private String etag;
    private String nextPageToken;
    private PageInfo pageInfo;
    private CommentThreadDTO[] items;
}
