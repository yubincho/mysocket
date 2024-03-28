package com.example.demo.board.dto.response;

import com.example.demo.board.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter // 대댓글 추가를 위해
public class CommentResponse {

    private Long id;
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;

    private List<CommentResponse> childComments = new ArrayList<>(); // 대댓글 목록


    // Comment 엔티티를 받아 DTO로 변환하는 생성자
    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.createdBy = comment.getCreatedBy();
        this.modifiedAt = comment.getModifiedAt();
        // 대댓글 목록도 변환하여 추가
        this.childComments = comment.getArticleComments()
                .stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());

    }


}
