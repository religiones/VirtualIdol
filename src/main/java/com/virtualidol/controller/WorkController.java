package com.virtualidol.controller;

import com.virtualidol.entities.Agent;
import com.virtualidol.entities.Message;
import com.virtualidol.entities.User;
import com.virtualidol.entities.Work;
import com.virtualidol.repository.AgentRepository;
import com.virtualidol.repository.UserRepository;
import com.virtualidol.repository.WorkRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class WorkController
{

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path={"/show/Work"})
    @ResponseBody
    public Message Get(@RequestBody User user_request)
    {
        try
        {
            User user = this.userRepository.findByAccount(user_request.getAccount());
            if (user != null) {
                Message message = new Message();
                List works = this.workRepository.findAll();
                message.setResult(works);
                return message;
            }

            Message message = new Message();
            message.setResult("用户不存在，请注册账户");
            return message;
        }
        catch (Exception e)
        {
            Message message = new Message();
            message.setResult("未知异常");
            return message;
        }
    }

    @PostMapping(path={"/new/Work"})
    @ResponseBody
    public Message Add(@RequestBody Work work_request) {
        try { Agent agent_request = work_request.getAgentFk();
            Agent agent = this.agentRepository.findAgentById(Long.valueOf(agent_request.getId()));
            if (agent != null) {
                this.workRepository.save(work_request);
                Message message = new Message();
                message.setResult("投稿成功");
                return message;
            }

            Message message = new Message();
            message.setResult("投您还不是经纪人，不能投稿");
            return message;
        }
        catch (Exception e)
        {
            Message message = new Message();
            if ((e instanceof DataIntegrityViolationException))
                message.setResult("作品已存在");
            else {
                message.setResult("未知异常");
            }
            return message;
        }
    }

//    @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST}, name="/fileUpload")
//    @ResponseBody
//    public Message multifileUpload(HttpServletRequest request)
//    {
//        List files = ((MultipartHttpServletRequest)request).getFiles("fileName");
//        Message res = new Message();
//        Message message = new Message();
//        if (files.isEmpty()) {
//            message.setResult("文件已丢失，请重新上传");
//            return message;
//        }
//        String path = WorkController.class.getResource("/").toString();
//        int end = path.indexOf("/classes/");
//        String work_path = path.substring(0, end) + ((MultipartFile)files.get(0)).getOriginalFilename();
//        File workDir = new File(work_path);
//        if (!workDir.exists()) {
//            workDir.mkdir();
//        }
//        List urls = new ArrayList();
//        for (MultipartFile file : files) {
//            String fileName = file.getOriginalFilename();
//            if (file.isEmpty()) {
//                message.setResult("文件已损坏，请重新上传");
//                return message;
//            }
//            File work = new File(work_path, fileName);
//            try {
//                file.transferTo(work);
//                urls.add(work.getAbsolutePath());
//            } catch (Exception e) {
//                e.printStackTrace();
//                message.setResult("未知异常");
//                return message;
//            }
//        }
//
//        return res;
//    }
}