package com.example.mall.api;

import com.example.mall.dao.CartDao;
import com.example.mall.model.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartApi {
    @Autowired
    private CartDao cartDao;

    @GetMapping("/api/cart/add")
    public Integer addProduct(@RequestParam("productId") Integer productId,@RequestParam("qty") Integer qty){
        return cartDao.addCart(productId,qty);
    }

    @GetMapping("/api/cart/select")
    public List<CartInfo> selectCart(){
        return cartDao.selectCart();
    }

    @GetMapping("/api/cart/delete")
    public Integer deleteCart(@RequestParam("cartId") Integer cartId){
        return cartDao.deleteCart(cartId);
    }

    //清空购物车
    @GetMapping("/api/cart/clear")
    public Integer deleteAll(){
        return cartDao.deleteAll();
    }
}
