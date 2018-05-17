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

    @Autowired
    UserRepository userRepository;

    public String userLogin(Users user){
        Users users = userRepository.findByUserName(user.getUserName());

        if (users == null)
            return "用户不存在";
        else {
            if (users.getUserPassword().equals(user.getUserPassword()))
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
            userRepository.save(user);
            return "注册成功";
        }
    }
}
