package com.virtualidol.controller;

import com.virtualidol.entities.Agent;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.repository.AgentRepository;
import com.virtualidol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgentController
{

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/new/Agent"})
    @ResponseBody
    public Message Add(@RequestBody Agent agent_Request)
    {
        try
        {
            User user1 = agent_Request.getUserFk();
            User user2 = (User)this.userRepository.getOne(Long.valueOf(user1.getId()));
            if (user1.getPassword().equals(user2.getPassword())) {
                this.agentRepository.save(agent_Request);
                Message res = new Message();
                Agent agent = this.agentRepository.findAgentByUserFk(user1);
                res.setResult(agent);
                return res;
            }

            Message res = new Message();
            res.setResult("账号不合法");
            return res;
        }
        catch (Exception e)
        {
            Message message = new Message();
            if ((e instanceof DataIntegrityViolationException)) {
                message.setResult("账号已存在");
                return message;
            }
            message.setResult("未知异常");
            return message;
        }
    }

    @PostMapping(path={"/show/Agent"})
    @ResponseBody
    public Message Get(@RequestBody User u) {
        try {
            User user = (User)this.userRepository.getOne(Long.valueOf(u.getId()));
            Agent agent = this.agentRepository.findAgentByUserFk(user);
            if (agent != null) {
                Message res = new Message();
                res.setResult(agent);
                return res;
            }

            Message res = new Message();
            res.setResult("您还不是经纪人");
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