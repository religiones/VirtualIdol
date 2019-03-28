package com.virtualidol.controller;

import com.virtualidol.entities.Favorite;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.repository.FavoriteRepository;
import com.virtualidol.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FavoriteController
{

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/new/Favorite"})
    @ResponseBody
    public Message Add(@RequestBody Favorite favorite_request)
    {
        try
        {
            User user1 = favorite_request.getUserFk();
            User user2 = (User)this.userRepository.getOne(Long.valueOf(user1.getId()));
            if (user1.getPassword().equals(user2.getPassword())) {
                this.favoriteRepository.save(favorite_request);
                Message res = new Message();
                List favorites = this.favoriteRepository.findAllByUserFk(favorite_request.getUserFk());
                res.setResult(favorites);
                return res;
            }

            Message res = new Message();
            res.setResult("账户密码不正确");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }

    @PostMapping(path={"/show/Favorite"})
    @ResponseBody
    public Message Get(@RequestBody User user_request) {
        try { User user = (User)this.userRepository.getOne(Long.valueOf(user_request.getId()));
            if (user.getPassword().equals(user_request.getPassword())) {
                Message res = new Message();
                List favorites = this.favoriteRepository.findAllByUserFk(user_request);
                res.setResult(favorites);
                return res;
            }

            Message res = new Message();
            res.setResult("账户密码不正确");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }

    @PostMapping(path={"/delete/Favorite"})
    @ResponseBody
    public Message Delete(@RequestBody Favorite favorite_request) {
        try { User user1 = favorite_request.getUserFk();
            User user2 = (User)this.userRepository.getOne(Long.valueOf(user1.getId()));
            if (user1.getPassword().equals(user2.getPassword())) {
                this.favoriteRepository.delete(favorite_request);
                Message res = new Message();
                List favorites = this.favoriteRepository.findAllByUserFk(user1);
                res.setResult(favorites);
                return res;
            }

            Message res = new Message();
            res.setResult("账号不合法");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }
}