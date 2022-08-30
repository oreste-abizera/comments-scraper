package rw.oreste.comments.server.utils.dtos;

import lombok.Data;

@Data
public class CommentThreadSnippetDTO {
    private String channelId;
    private String videoId;
    private TopLevelCommentDTO topLevelComment;
    private Boolean canReply;
    private String totalReplyCount;
    private Boolean isPublic;
}
