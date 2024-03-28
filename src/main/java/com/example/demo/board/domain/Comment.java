package com.example.demo.board.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Article article; // 게시글 (ID)

    @Setter
    @Column(nullable = false, length = 500)
    private String content;

    // 부모 댓글 ID 설정
    @Setter @Getter
    @Column(updatable = false)
    private Long parentCommentId; // 부모 댓글 ID

    // 부모 댓글 ID 설정 , @Setter 와 같아서 생략
//    public void setParentCommentId(Long parentCommentId) {
//        this.parentCommentId = parentCommentId;
//    }


    @ToString.Exclude
    @OrderBy("createdAt ASC")
    @OneToMany(mappedBy = "parentCommentId", cascade = CascadeType.ALL)
    private final Set<Comment> articleComments = new LinkedHashSet<>();

    @Builder
    public Comment(Article article, String content, Long parentCommentId) {
        this.article = article;
        this.parentCommentId = parentCommentId;
        this.content = content;
    }

    // Comment 엔티티 업데이트
    public void update(String content) {
        this.content = content;
    }


    // 대댓글 추가 메소드
    public void addChildComment(Comment child) {
        articleComments.add(child);
        child.setParentCommentId(this.id); // 대댓글이 현재 댓글을 부모로 참조하도록 설정
    }


    // ID 만 동등성 검사
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }


}
