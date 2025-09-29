package com.wolfman.mall.product.mapper;

import com.wolfman.mall.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM products WHERE product_id = #{productId}")
    Product selectByProductId(@Param("productId") String productId);

    @Select("SELECT * FROM products WHERE category_id = #{categoryId}")
    List<Product> selectByCategoryId(@Param("categoryId") String categoryId);

    @Select("SELECT * FROM products WHERE brand = #{brand} AND category_id = #{categoryId}")
    List<Product> selectByBrandAndCategoryId(@Param("brand") String brand, @Param("categoryId") String categoryId);
}