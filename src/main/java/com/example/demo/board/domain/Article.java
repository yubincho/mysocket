package com.example.demo.board.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Setter
    @Column(name = "title", nullable = false, length = 10000)
    private String title;

    @Setter
    @Column(name = "content", nullable = false)
    private String content;

    @Setter
    @Column(name = "hashtag", nullable = true)
    private String hashtag;

    @ToString.Exclude
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> articleComments = new LinkedHashSet<>();

    @Builder
    public Article (String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
//        this.articleComments = new LinkedHashSet<>();
//        if (articleComments != null) {
//            this.articleComments.addAll(articleComments);
//        }
    }

    // Article 엔티티 업데이트
    public Article update(
            String title, String content,
            String hashtag, LocalDateTime createdAt,
            String createdBy, LocalDateTime modifiedAt,
            Set<Comment> newComments
    ) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;

        return this; // 업데이트된 객체를 반환
    }


    // ID 만 동등성 검사
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
