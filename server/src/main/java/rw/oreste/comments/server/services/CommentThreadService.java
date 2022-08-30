package rw.oreste.comments.server.services;

import rw.oreste.comments.server.utils.dtos.CommentThreadDTO;
import rw.oreste.comments.server.utils.dtos.CommentsSearchDTO;
import rw.oreste.comments.server.utils.dtos.SearchDTO;

import java.util.List;

public interface CommentThreadService {
    List<CommentThreadDTO> searchComments(CommentsSearchDTO searchDTO);
}
