package com.example.mall.dao;

import com.example.mall.model.CartInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartDao {

    @Insert("insert cart (productId,qty) values(#{productId},#{qty})")
    Integer addCart(Integer productId, Integer qty);

    @Select("select cart.id as cartId,product.id as productId,product.name as productName,product.pic as productPic,product.price as productPrice,cart.qty as qty " +
            "from cart " +
            "left join product on cart.productId = product.id")
    List<CartInfo> selectCart();

    @Delete("delete from cart where id = #{id}")
    public Integer deleteCart(Integer id);

    @Delete(" delete from cart ")
    public Integer deleteAll();

}
