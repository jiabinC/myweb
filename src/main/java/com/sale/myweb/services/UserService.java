package com.sale.myweb.services;
/**
 * @author abin
 * @date 2018/5/15 18:28
 * @version 1.0
 */

import com.sale.myweb.DAO.UserRepository;
import com.sale.myweb.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    //使用构造器注入 可以指定成员变量的加载顺序
    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    public String userLogin(Users user){
        Users users = userRepository.findByUserName(user.getUserName());

        if (users == null)
            return "用户不存在";
        else {
            if (users.getUserPassword().equals(String.valueOf(user.getUserPassword().hashCode())))
            return "登陆成功";

          else
            return "密码输入有误";
        }


    }

    public String userRegister(Users user) {
        Users users = userRepository.findByUserName(user.getUserName());
        if (users!=null)
            return "该用户名已被注册";
        else {
            user.setUserPassword(String.valueOf(user.getUserPassword().hashCode()));
            userRepository.save(user);
            return "注册成功";
        }
    }
}
