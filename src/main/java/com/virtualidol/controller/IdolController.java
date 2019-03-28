package com.virtualidol.controller;

import com.virtualidol.entities.Idol;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.Team;
import com.virtualidol.repository.IdolRepository;
import com.virtualidol.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IdolController
{

    @Autowired
    IdolRepository idolRepository;

    @Autowired
    TeamRepository teamRepository;

    @PostMapping(path={"/new/Idol"})
    @ResponseBody
    public Message Add(@RequestBody Idol idol_request)
    {
        try
        {
            Team team1 = idol_request.getTeamFk();
            Team team2 = this.teamRepository.findTeamById(Long.valueOf(team1.getId()));
            if (team2 != null) {
                idol_request.setTeamFk(team1);
                this.idolRepository.save(idol_request);
                Message res = new Message();
                Idol idol = this.idolRepository.findIdolByName(idol_request.getName());
                res.setResult(idol);
                return res;
            }

            Message res = new Message();
            res.setResult("团队不存在");
            return res;
        }
        catch (Exception e)
        {
            Message res = new Message();
            if ((e instanceof DataIntegrityViolationException)) {
                res.setResult("偶像已存在，无法创建");
            }
            else {
                res.setResult("未知错误");
            }
            return res;
        }
    }

    @PostMapping(path={"/show/Idol"})
    @ResponseBody
    public Message Get(@RequestBody Idol idol_request) {
        try {
            Idol idol = this.idolRepository.findIdolByName(idol_request.getName());
            if (idol != null) {
                Message res = new Message();
                res.setResult(idol);
                return res;
            }

            Message res = new Message();
            res.setResult("偶像不存在");
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