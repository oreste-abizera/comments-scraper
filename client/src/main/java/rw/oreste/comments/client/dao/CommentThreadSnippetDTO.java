package rw.oreste.comments.client.dao;

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
