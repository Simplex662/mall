package com.example.mall.dao;

import com.example.mall.model.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface OrderItemDao {
    @Insert(" insert into orderItem (orderId,productId,qty) values (#{orderId},#{productId},#{qty}) ")
    Integer addOrderItem(Long orderId, Integer productId, Integer qty);

    @Select(" select OI.id as id , OI.productId,OI.orderId, OI.qty, P.`name` as  productName,  P.pic as  productPic,P.price as  productPrice \n" +
            "from orderItem OI \n" +
            "left join product P \n" +
            "on OI.productId = P.id \n" +
            "where OI.orderId = #{orderId}")
    List<OrderItem> selectOrderItem(Long orderId);

}
