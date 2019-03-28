package com.virtualidol.controller;

import com.virtualidol.entities.Agent;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.Team;
import com.virtualidol.entities.User;
import com.virtualidol.repository.AgentRepository;
import com.virtualidol.repository.TeamRepository;
import com.virtualidol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamController
{

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/new/Team"})
    @ResponseBody
    public Message Add(@RequestBody Team team_request)
    {
        try
        {
            User user1 = team_request.getUserFk();
            User user2 = this.userRepository.findUserById(Long.valueOf(user1.getId()));
            if (user2 != null) {
                Agent agent = this.agentRepository.findAgentByUserFk(user2);
                if (agent != null) {
                    this.teamRepository.save(team_request);
                    Team team = this.teamRepository.findTeamByUserFk(user2);
                    agent.setTeamFk(team);
                    this.agentRepository.save(agent);
                    Message res = new Message();
                    res.setResult(team);
                    return res;
                }

                Message res = new Message();
                res.setResult("您还不是经纪人，不能创建队伍");
                return res;
            }

            Message res = new Message();
            res.setResult("用户不存在");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            if ((e instanceof DataIntegrityViolationException))
                res.setResult("队伍已存在");
            else {
                res.setResult("未知异常");
            }
            return res;
        }
    }
}