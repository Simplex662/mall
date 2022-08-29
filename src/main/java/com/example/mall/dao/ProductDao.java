package com.example.mall.dao;

import com.example.mall.model.Product;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductDao {
    //添加
    @Insert("insert product (name,pic,price,brief) value(#{name},#{pic},#{price},#{brief})")
    public Integer addProduct(String name, String pic, BigDecimal price,String brief );

    //查询所有
    @Select(" select  *  from  product ")
    List<Product> selectProduct();

    //通过id查询
    @Select(" select  *  from  product  where id = #{id} ")
    Product selectOneProduct(Integer id);

    //删除
    @Delete(" DELETE  from product where id = #{id} ")
    Integer deleteProduct(Integer id);

    //修改
    @Update(" update product set name=#{name},pic=#{pic},price=#{price},brief=#{brief}, where id = #{id} ")
    Integer editProduct(Integer id,String name,String pic,BigDecimal price,String brief);
}
