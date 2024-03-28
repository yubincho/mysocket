//package com.example.demo.repository;
//
//import com.example.demo.board.repository.CommentRepository;
//import com.example.demo.board.repository.ArticleRepository;
//import com.example.demo.board.config.JpaConfig;
//import com.example.demo.board.domain.Article;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Import;
//
//import javax.persistence.EntityNotFoundException;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//
//@DisplayName("JPA 연결 테스트")
//@Import(JpaConfig.class)
//@DataJpaTest
//class JpaRepositoryTest {
//
//    private final ArticleRepository articleRepository;
//    private final CommentRepository articleCommentRepository;
//
//
//    public JpaRepositoryTest(
//            @Autowired ArticleRepository articleRepository,
//            @Autowired CommentRepository articleCommentRepository) {
//        this.articleRepository = articleRepository;
//        this.articleCommentRepository = articleCommentRepository;
//    }
//
//
//    @DisplayName("select test")
//    @Test
//    void repositoryTest() {
//
//        List<Article> articles = articleRepository.findAll();
//
//        assertThat(articles)
//                .isNotNull()
//                .hasSize(0);
//
//    }
//
//
//    @DisplayName("insert test")
//    @Test
//    void repositoryTest2() {
//
//        long previousCount = articleRepository.count();
//        Article article = Article.builder().title("new title").content("new content").build();
//        Article savedArticle = articleRepository.save(article);
//
//        List<Article> articles = articleRepository.findAll();
//
//        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
//
//
//    }
//
//
//    @DisplayName("update test")
//    @Test
//    void repositoryTest3() {
//
//        Article article = Article.builder().title("new title").content("new content").build();
//        articleRepository.saveAndFlush(article);
//        Article newarticle = articleRepository.findById(1L)
//                .orElseThrow(() -> new EntityNotFoundException("Article with ID 1 not found"));
//
//        String updatedHashtag = "#springboot";
//        newarticle.setHashtag(updatedHashtag);
//
//        Article savedArticle = articleRepository.saveAndFlush(newarticle);
//
//        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
//
//    }
//
//
//    @DisplayName("delete test")
//    @Test
//    void repositoryTest4() {
//
//        Article article = Article.builder().title("new title").content("new content").build();
//        articleRepository.saveAndFlush(article);
//        long previousArticleCount = articleRepository.count();
//
//        articleRepository.delete(article);
//
//        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
//
//    }
//
//
//}