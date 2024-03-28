package com.example.demo.board.dto.request;

import com.example.demo.board.domain.Comment;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommentRequest {

    @NotNull()
    private String content;

    private Long parentCommentId;  // nullable한 변수

    public Comment toEntity() {
        return Comment.builder()
                .content(content)
                .parentCommentId(parentCommentId != null ? parentCommentId : 0)
                .build();
    }
}
