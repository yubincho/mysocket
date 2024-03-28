package com.example.demo.board.service;

import com.example.demo.board.dto.ArticleDto;
import com.example.demo.board.dto.request.ArticleRequest;
import com.example.demo.board.domain.Article;
import com.example.demo.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Article save(ArticleRequest request) {
        Article article = request.toEntity();
        return articleRepository.save(article);
    }


    @Transactional(readOnly = true)
    public List<Article> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }


    public Article getOneById(Long id) {
        Article findArticle = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article with id " + id + " not found"));
        return findArticle;
    }

    @Transactional
    public Article updateOneById(ArticleRequest requestDto, Long id) {
        Article findArticle = this.getOneById(id);

        if (findArticle != null) {
            LocalDateTime now = LocalDateTime.now(); // 현재 시간 취득
            // DTO를 통해 엔티티 업데이트 로직 호출
            requestDto.applyTo(findArticle, now);
            return articleRepository.save(findArticle); // 변경 사항 저장.
        }
        throw new EntityNotFoundException("Article not found with id " + id);
    }



}
