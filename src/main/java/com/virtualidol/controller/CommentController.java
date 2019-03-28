package com.virtualidol.controller;

import com.virtualidol.entities.Comment;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.entities.Work;
import com.virtualidol.repository.CommentRepository;
import com.virtualidol.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController
{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/new/Comment"})
    @ResponseBody
    public Message Add(@RequestBody Comment comment_requset)
    {
        try
        {
            User user1 = comment_requset.getUserFk();
            User user2 = (User)this.userRepository.getOne(Long.valueOf(user1.getId()));
            if (user1.getPassword().equals(user2.getPassword())) {
                comment_requset.setUserFk(user1);
                this.commentRepository.save(comment_requset);
                Message res = new Message();
                List comments = this.commentRepository.findAllByWorkFk(comment_requset.getWorkFk());
                res.setResult(comments);
                return res;
            }

            Message res = new Message();
            res.setResult("账户不合法");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }

    @PostMapping(path={"/show/workComment"})
    @ResponseBody
    public Message GetWorkComment(@RequestBody Work work_request) {
        try { Message res = new Message();
            List comments = this.commentRepository.findAllByWorkFk(work_request);
            res.setResult(comments);
            return res;
        } catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }

    @PostMapping(path={"/show/userComment"})
    @ResponseBody
    public Message GetUserComment(@RequestBody User user_request) {
        try { User user = (User)this.userRepository.getOne(Long.valueOf(user_request.getId()));
            if (user_request.getPassword().equals(user.getPassword())) {
                Message res = new Message();
                List comments = this.commentRepository.findAllByUserFk(user_request);
                res.setResult(comments);
                return res;
            }

            Message res = new Message();
            res.setResult("账户不合法");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            res.setResult("未知错误");
            return res;
        }
    }

    @PostMapping(path={"/delete/Comment"})
    @ResponseBody
    public Message Delete(@RequestBody Comment comment_request) {
        try { User user1 = comment_request.getUserFk();
            User user2 = (User)this.userRepository.getOne(Long.valueOf(user1.getId()));
            if (user1.getPassword().equals(user2.getPassword())) {
                Comment comment = (Comment)this.commentRepository.getOne(Long.valueOf(comment_request.getId()));
                if (comment != null) {
                    this.commentRepository.delete(comment);
                    Message res = new Message();
                    List comments = this.commentRepository.findAllByUserFk(comment_request.getUserFk());
                    res.setResult(comments);
                    return res;
                }

                Message res = new Message();
                res.setResult("评论不存在");
                return res;
            }

            Message res = new Message();
            res.setResult("账户不合法");
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