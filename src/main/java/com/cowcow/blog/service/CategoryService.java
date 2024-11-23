package com.cowcow.blog.service;

import com.cowcow.blog.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    //分类列表
    List<Category> list();

    //添加分类
    void insert(Category category);

    //根据id查询
    Category get(Long id);

    //修改分类
    void update(Category category);

    //删除分类
    void delete(Long id);

    //条件分页查询
    Map<String, Object> queryPage(Long current, Long limit, Category category);
}
