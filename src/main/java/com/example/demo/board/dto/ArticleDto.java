package com.example.demo.board.dto;

import java.time.LocalDateTime;


// 페이징 적용
public record ArticleDto(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {



}
