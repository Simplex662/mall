package com.example.mall.dao;

import com.example.mall.model.OrderMaster;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface OrderMasterDao {
    //新建订单
    @Insert("insert into ordermaster (id,receiver,phoneNumber,address) values (#{id},#{receiver},#{phoneNumber},#{address})")
    public Integer addOrderMaster(Long id, String receiver, String phoneNumber, String address);

    @Select("select * from ordermaster")
    public List<OrderMaster> selectOrder();

}

