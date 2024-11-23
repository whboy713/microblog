package com.cowcow.blog.controller;

import com.cowcow.blog.entity.Category;
import com.cowcow.blog.service.CategoryService;
import com.cowcow.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //分类列表
    @PostMapping("queryList")
    public Result articleList() {
        List<Category> list = categoryService.list();
        return Result.ok(list);
    }

    //条件分页查询
    @PostMapping("queryListPage/{current}/{limit}")
    public Result queryListPage(@PathVariable Long current,
                                @PathVariable Long limit,
                                @RequestBody(required = false) Category category) {
        Map<String,Object> data = categoryService
                .queryPage(current,limit,category);
        return Result.ok(data);
    }

    //添加分类
    @PostMapping("addCategory")
    public Result addCategory(@RequestBody Category category) {
        categoryService.insert(category);
        return Result.ok();
    }

    //根据id查询
    @GetMapping("getCategory/{id}")
    public Result getCategory(@PathVariable Long id) {
        Category category = categoryService.get(id);
        return Result.ok(category);
    }
    //修改分类
    @PutMapping("updateCategory")
    public Result updateCategory(@RequestBody Category category) {
        categoryService.update(category);
        return Result.ok();
    }

    //删除分类
    @DeleteMapping("deleteCategory/{id}")
    public Result deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return Result.ok();
    }
}
