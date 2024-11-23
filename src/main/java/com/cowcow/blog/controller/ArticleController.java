package com.cowcow.blog.controller;

import com.cowcow.blog.entity.Article;
import com.cowcow.blog.service.ArticleService;
import com.cowcow.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //文章列表
    @PostMapping  ("queryList")
    public Result articleList(@RequestBody(required = false) Article article) {
        List<Article> list  = articleService.list(article);
        return Result.ok(list);
    }

    //添加文章
    @PostMapping("addArticle")
    public Result addArticle(@RequestBody Article article) {
        articleService.insert(article);
        return Result.ok();
    }

    //根据id查询
    @GetMapping("getArticle/{id}")
    public Result getArticle(@PathVariable Long id) {
        Article article = articleService.get(id);
        return Result.ok(article);
    }
    //修改文章
    @PutMapping("updateArticle")
    public Result updateArticle(@RequestBody Article article) {
        articleService.update(article);
        return Result.ok();
    }

    //删除文章
    @DeleteMapping("deleteArticle/{id}")
    public Result deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
        return Result.ok();
    }
}
