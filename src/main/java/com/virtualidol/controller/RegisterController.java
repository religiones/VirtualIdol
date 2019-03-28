package com.virtualidol.controller;

import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController
{

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/register"})
    @ResponseBody
    public Message Register(@RequestBody User u)
    {
        try
        {
            this.userRepository.save(u);
            User user = this.userRepository.findByAccount(u.getAccount());
            Message message = new Message();
            message.setResult(user);
            return message;
        } catch (Exception e) {
            Message message = new Message();
            if ((e instanceof DataIntegrityViolationException)) {
                message.setResult("账号已存在");
                return message;
            }
            message.setResult("未知异常，请稍后重试");
            return message;
        }
    }
}