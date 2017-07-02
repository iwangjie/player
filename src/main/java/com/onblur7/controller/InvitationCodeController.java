package com.onblur7.controller;

import com.onblur7.entity.InvitationCode;
import com.onblur7.repository.InvitationCodeRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ronger on 2017/7/2.
 */
@Controller
public class InvitationCodeController {
    @Autowired
    private InvitationCodeRepository invitationCodeRepository;

    @GetMapping("/checkCode")
    @ResponseBody
    public boolean generate(){
        return true;
    }

    @PostMapping("/checkCode")
    @ResponseBody
    public boolean checkCode(HttpServletRequest request){
        String invitationcode = request.getParameter("invitationcode");
        InvitationCode invitationCode = invitationCodeRepository.findByCodeAndState(invitationcode,0);
        System.out.print(invitationCode == null);
        return invitationCode == null;
    }
}
