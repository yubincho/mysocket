//package com.example.demo.board.dto.response;
//
//import com.example.demo.board.domain.Article;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.Set;
//import java.util.stream.Collectors;
//
////public record ArticleResponse (
////        String title, String content
////) {
////
////    // Article 엔티티로부터 ArticleResponse를 생성하는 정적 팩토리 메서드
////    public static ArticleResponse from(Article article) {
////        return new ArticleResponse(article.getTitle(), article.getContent());
////    }
////}
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//public class ArticleResponse {
//
//    private String title;
//    private String content;
//    private String hashtag;
//
//    private LocalDateTime createdAt;
//    private String createdBy;
//    private LocalDateTime modifiedAt;
//
//    private Set<CommentResponse> articleComments;
//
//
//
//    // @AllArgsConstructor
////    public ArticleResponse(String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt) {
////        this.title = title;
////        this.content = content;
////        this.hashtag = hashtag;
////        this.createdAt = createdAt;
////        this.createdBy = createdBy;
////        this.modifiedAt = modifiedAt;
////    }
//
//
//    public static ArticleResponse from(Article article) {
//
//        Set<CommentResponse> comments = article.getArticleComments().stream()
//                .map(comment -> new CommentResponse(
//                        comment.getId(),
//                        comment.getContent(),
//                        comment.getCreatedAt(),
//                        comment.getCreatedBy(),
//                        comment.getModifiedAt(),
//                        // 다른 필요한 필드를 여기에 추가
//                ))
//                .collect(Collectors.toSet());
//
//        return new ArticleResponse(
//                article.getTitle(),
//                article.getContent(),
//                article.getHashtag(),
//                article.getCreatedAt(),
//                article.getCreatedBy(),
//                article.getModifiedAt(),
//                comments
//        );
//    }
//
//}
