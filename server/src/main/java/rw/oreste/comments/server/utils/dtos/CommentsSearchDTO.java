package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class CommentsSearchDTO {
    private String searchKeyword;
    private String channelId;
}
