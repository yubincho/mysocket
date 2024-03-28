package com.example.demo.board.controller;

import com.example.demo.board.domain.Comment;
import com.example.demo.board.dto.request.CommentRequest;
import com.example.demo.board.dto.response.CommentResponse;
import com.example.demo.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;


    // 댓글 쓰기
    @PostMapping("/{articleId}")
    public Long createComment(@PathVariable Long articleId, @RequestBody CommentRequest dto) {
        Comment comment = this.commentService.writeComment(articleId, dto);
        return comment.getId(); // 수정하기
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<List<CommentResponse>> findAllTopLevelComments(@PathVariable Long articleId) {
        List<CommentResponse> comments = commentService.findAllTopLevelComments(articleId);
        return ResponseEntity.ok(comments);
    }



}
