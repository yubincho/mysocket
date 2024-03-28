//package com.example.demo.board.controller;
//
//import com.example.demo.board.domain.Article;
//import com.example.demo.board.dto.request.ArticleRequest;
//import com.example.demo.board.dto.response.ArticleResponse;
//import com.example.demo.board.service.ArticleService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api")
//public class ArticleController {
//
//    private final ArticleService articleService;
//
//
//    @PostMapping("/create")
//    public ResponseEntity<Article> create(@RequestBody ArticleRequest request) {
//        Article article = articleService.save(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(article);
//        // entity를 그대로 내려줌
//    }
//
//
//    //
//    @GetMapping("/articles")
//    public ResponseEntity<List<ArticleResponse>> findArticlesWithComments() {
//        List<ArticleResponse> articles = articleService.findAll()
//                .stream()
////                .map(article -> ArticleResponse.from(article))
//                .map(ArticleResponse::from)
//                .toList();
//        return ResponseEntity.ok(articles);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ArticleResponse> findOneById(@PathVariable Long id) {
//        Article findOne = articleService.getOneById(id);
//        ArticleResponse result = ArticleResponse.from(findOne);
//        return ResponseEntity.ok(result);
//    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity<ArticleResponse> updateOneById(
//            @RequestBody ArticleRequest requestDto,
//            @PathVariable Long id) {
//        Article result = this.articleService.updateOneById(requestDto, id);
//        ArticleResponse response = ArticleResponse.from(result);
//        return ResponseEntity.ok(response);
//    }
//
//
//
//
//}
