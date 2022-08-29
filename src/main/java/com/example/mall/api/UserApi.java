package com.example.mall.api;

import com.example.mall.dao.UserDao;
import com.example.mall.model.ApiResponse;
import com.example.mall.model.LoginInfo;
import com.example.mall.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApi {
    @Autowired
    private UserDao userDao;
    //删
    @GetMapping("/api/user/delete")
    public Integer deleteUser(@RequestParam("id") Integer id){
        return userDao.deleteUser(id);
    }
    //查
    @GetMapping("/api/user/select")
    public List<UserInfo> selectUses(){
        return userDao.selectUsers();
    }
    //测试方法
    @GetMapping("/api/test")
    public String test(@RequestParam("id") int id){
        return "接收的参数id="+id;
    }
    //登录
    @PostMapping("/api/user/login")
    public ApiResponse login(@RequestBody LoginInfo loginInfo){

        UserInfo user = userDao.login(loginInfo.getUserId(),loginInfo.getPassword());
        ApiResponse apiResponse = new ApiResponse();

        if (user != null){
            apiResponse.setCode(0);
            apiResponse.setData(user);
            apiResponse.setMsg("登录成功");
        }else {
            apiResponse.setCode(1);
            apiResponse.setMsg("用户名或密码错误");
        }

        return apiResponse;
    }
    @PostMapping("/api/user/selectOne")
    public UserInfo selectOneUser(@RequestParam("id") Integer id) {
        return  userDao.selectOneUser(id);
    }
    //添加
    @PostMapping("/api/user/add")
    public Integer userRegister(@RequestBody UserInfo userInfo){
        return userDao.addUser(userInfo.getUserId(), userInfo.getPassword());
    }
    //修改密码
    @PostMapping("/api/user/update")
    public Integer updateUser(@RequestBody UserInfo userInfo){
        return  userDao.updatePassword(userInfo.getId(), userInfo.getPassword());
    }
}
