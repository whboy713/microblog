package com.cowcow.blog.service.impl;

import com.cowcow.blog.entity.Category;
import com.cowcow.blog.mapper.CategoryMapper;
import com.cowcow.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //分类列表
    @Override
    public List<Category> list() {
        List<Category> list = categoryMapper.selectList();
        return list;
    }

    //添加分类
    @Override
    public void insert(Category category) {
        categoryMapper.insertCategory(category);
    }

    //根据id查询
    @Override
    public Category get(Long id) {
        return categoryMapper.getCategory(id);
    }

    //修改分类
    @Override
    public void update(Category category) {
        categoryMapper.updateCategory(category);
    }

    //删除分类
    @Override
    public void delete(Long id) {
        categoryMapper.deleteCategory(id);
    }

    //条件分页查询
    @Override
    public Map<String, Object> queryPage(
            Long current, Long limit, Category category) {
        //查询总记录数
        Long total = categoryMapper.selectCount(category);

        //分页条件查询
        Long begin = (current - 1) * limit;
        List<Category> list = categoryMapper.pageList(begin, limit, category);

        //封装
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("list", list);
        return map;
    }
}
