package com.cowcow.blog.service;

import com.cowcow.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> list(Article article);

    //添加文章
    void insert(Article article);

    //根据id查询
    Article get(Long id);

    //修改文章
    void update(Article article);

    //删除文章
    void delete(Long id);
}
