package com.cowcow.blog.mapper;

import com.cowcow.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {

    //查询数据list集合
    List<Category> selectList();

    //添加分类
    void insertCategory(Category category);

    //根据id查询
    Category getCategory(Long cid);

    //修改分类
    void updateCategory(Category category);

    //删除分类
    void deleteCategory(Long cid);

    //总记录数
    Long selectCount(Category category);

    //条件分页查询
    List<Category> pageList(@Param("begin") Long begin,
                            @Param("limit") Long limit,
                            @Param("vo") Category category);
}
