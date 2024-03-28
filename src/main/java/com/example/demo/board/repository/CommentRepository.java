package com.example.demo.board.repository;

import com.example.demo.board.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {

//    @Query(value = "SELECT * from COMMENT c where c.parentCommentId = 0", nativeQuery = true)
//    List<Comment> findAll();

    @Query("SELECT c FROM Comment c WHERE c.article.id = :articleId AND (c.parentCommentId IS NULL OR c.parentCommentId = 0)")
    List<Comment> findByArticleIdWithTopLevelComments(@Param("articleId") Long articleId);


}
