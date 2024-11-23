package com.cowcow.blog.mapper;

import com.cowcow.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {
    List<Article> selectList(Article article);

    //添加文章
    void insertArticle(Article article);

    //根据id查询
    Article getArticle(Long id);

    //修改文章
    void updateArticle(Article article);

    //删除文章
    void deleteArticle(Long id);
}
