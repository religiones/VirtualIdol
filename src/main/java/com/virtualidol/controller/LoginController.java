package com.virtualidol.controller;

import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController
{

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/login"})
    @ResponseBody
    public Message Login(@RequestBody User u)
    {
        try
        {
            String account = u.getAccount();
            String password = u.getPassword();
            User user = this.userRepository.findByAccount(account);

            if (user.getPassword().equals(password)) {
                Message res = new Message();
                res.setResult(user);
                return res;
            }

            Message res = new Message();
            res.setResult("密码错误");
            return res;
        }
        catch (Exception e)
        {
            if ((e instanceof NullPointerException)) {
                Message res = new Message();
                res.setResult("账号不存在");
                return res;
            }

            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }
}