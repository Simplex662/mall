package com.example.mall.api;

import com.example.mall.dao.ProductDao;
import com.example.mall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductApi {
    @Autowired
    private ProductDao productDao;

    //添加一个商品
    @PostMapping("/api/product/add")
    public Integer addProduct(@RequestBody Product product) {
        return productDao.addProduct(product.getName(),product.getPic(),product.getPrice(),product.getBrief());
    }

    //查询某一个商品
    @GetMapping("/api/product/{id}")
    public  Product  selectOne(@PathVariable("id") Integer id){
        return productDao.selectOneProduct(id);
    }

    //查询商品列表
    @GetMapping("/api/product/select")
    public List<Product> selectProduct(){
        List<Product> products = productDao.selectProduct();
        return  products;
    }

    //修改商品
    @PostMapping("/api/product/edit")
    public Integer editProduct(Product product){
        Integer id = product.getId();
        String name = product.getName();
        String pic = product.getPic();
        BigDecimal price = product.getPrice();
        String brief = product.getBrief();

        return productDao.editProduct(id,name,pic,price,brief);
    }

    //删除某一个商品
    @GetMapping("/api/product/de lete")
    public  Integer deleteProduct( @RequestParam("id") Integer id3){
        return productDao.deleteProduct(id3);
    }

}
