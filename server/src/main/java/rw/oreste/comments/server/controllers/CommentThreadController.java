package rw.oreste.comments.server.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.oreste.comments.server.services.CommentThreadService;
import rw.oreste.comments.server.utils.ApiResponse;
import rw.oreste.comments.server.utils.dtos.CommentsSearchDTO;
import rw.oreste.comments.server.utils.dtos.SearchDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentThreadController {
    private final CommentThreadService commentThreadService;

    public CommentThreadController(CommentThreadService commentThreadService) {
        this.commentThreadService = commentThreadService;
    }

    @PostMapping("/search")
    public ApiResponse search(@Valid @RequestBody CommentsSearchDTO searchDTO) {
        return ApiResponse.success(commentThreadService.searchComments(searchDTO));
    }
}
