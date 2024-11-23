package com.cowcow.blog.service.impl;

import com.cowcow.blog.entity.Article;
import com.cowcow.blog.mapper.ArticleMapper;
import com.cowcow.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    //文章列表
    @Override
    public List<Article> list(Article article) {
        List<Article> list = articleMapper.selectList(article);
        return list;
    }

    //添加文章
    @Override
    public void insert(Article article) {
        articleMapper.insertArticle(article);
    }

    //根据id查询
    @Override
    public Article get(Long id) {
        return articleMapper.getArticle(id);
    }

    //修改文章
    @Override
    public void update(Article article) {
        articleMapper.updateArticle(article);
    }

    //删除文章
    @Override
    public void delete(Long id) {
        articleMapper.deleteArticle(id);
    }
}
