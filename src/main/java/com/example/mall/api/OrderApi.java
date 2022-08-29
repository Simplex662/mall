package com.example.mall.api;

import com.example.mall.dao.CartDao;
import com.example.mall.dao.OrderItemDao;
import com.example.mall.dao.OrderMasterDao;
import com.example.mall.model.CartInfo;
import com.example.mall.model.OrderItem;
import com.example.mall.model.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderApi {
    @Autowired
    private OrderMasterDao omd;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderItemDao oid;

    @PostMapping("/api/order/add")
    public Integer addOrderMaster(@RequestBody OrderMaster orderMaster){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmsss");
        String date = sdf.format(new Date());
        long id = Long.parseLong(date);
        String receiver = orderMaster.getReceiver();
        String phoneNumber = orderMaster.getPhoneNumber();
        String address = orderMaster.getAddress();
        Integer ret = omd.addOrderMaster(id, receiver, phoneNumber, address);
        //订单头持久化到数据库
        List<CartInfo> cartInfos = cartDao.selectCart();
        for (CartInfo cart : cartInfos) {
            oid.addOrderItem(id, cart.getProductId(), cart.getQty());
        }
        cartDao.deleteAll();
        return ret;
    }

    @GetMapping("/api/order/select")
    public List<OrderMaster> orderSelect(){
        return omd.selectOrder();
    }

    @GetMapping("/api/orderItem/select")
    public List<OrderItem> selectOrderItem(@RequestParam("orderId1") Long orderId){
        return oid.selectOrderItem(orderId);
    }

}
