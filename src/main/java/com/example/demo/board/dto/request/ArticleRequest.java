package com.example.demo.board.dto.request;

import com.example.demo.board.domain.Article;
import lombok.*;

import java.time.LocalDateTime;

//public record ArticleRequest(
//        String title, String content
//) {
//
//
//    // 유저 로그인하면 수정 + hashtag
//    public Article toEntity() {
//        return Article.builder()
//                .title(title)
//                .content(content)
//                .build();
//    }
//}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ArticleRequest {

    private String title;
    private String content;
    private String hashtag;


    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .hashtag(hashtag)
                .build();
    }

    // Article 엔티티에 데이터를 적용하는 메서드
    // 이 메서드는 엔티티를 직접 수정하지 않고, 수정할 데이터를 제공합니다.
    public void applyTo(Article article, LocalDateTime modifiedAt) {
        article.setTitle(this.title);
        article.setContent(this.content);
        article.setHashtag(this.hashtag);
        article.setModifiedAt(modifiedAt);
    }

}