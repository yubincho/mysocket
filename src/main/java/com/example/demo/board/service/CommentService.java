package com.example.demo.board.service;


import com.example.demo.board.domain.Article;
import com.example.demo.board.domain.Comment;
import com.example.demo.board.dto.request.CommentRequest;
import com.example.demo.board.dto.response.CommentResponse;
import com.example.demo.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {


    private final CommentRepository commentRepository;
    private final ArticleService articleService;


    /**
     * 댓글을 작성
     */
    @Transactional
    public Comment writeComment(Long articleId, CommentRequest requestDto) {
        Article article = this.articleService.getOneById(articleId);

        Comment comment = requestDto.toEntity();
        comment.setArticle(article);
        return this.commentRepository.save(comment);
    }

    /**
     * 대댓글을 작성
     *
     * @param parentId    부모 댓글의 ID
     * @param requestDto  대댓글 작성에 필요한 요청 데이터
     * @return 저장된 대댓글 엔티티
     */
    @Transactional
    public Comment writeReply(Long parentId, CommentRequest requestDto) {
        // 부모 댓글 조회
        Comment parentComment = this.commentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("부모 댓글이 존재하지 않습니다."));

        // 대댓글 엔티티 생성 및 부모 댓글 ID 설정
        Comment reply = requestDto.toEntity();
        reply.setParentCommentId(parentId); // 대댓글에 부모 댓글 ID 설정

        // 대댓글 저장
        return this.commentRepository.save(reply);
    }


    // 댓글과 대댓글 모두 보여주기
    @Transactional(readOnly = true)
    public List<CommentResponse> findAllTopLevelComments(Long articleId) {
        List<Comment> topLevelComments = commentRepository.findByArticleIdWithTopLevelComments(articleId);

        // DTO 변환
        return topLevelComments.stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }



    // 대댓글 쓰기
    @Transactional
    public void addReplyToComment(Long commentId, Comment reply) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + commentId));
        parentComment.addChildComment(reply);
        commentRepository.save(reply);
    }

    

}
