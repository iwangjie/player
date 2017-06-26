package com.onblur7.controller;


import com.onblur7.entity.Author;
import com.onblur7.entity.Role;
import com.onblur7.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Set;

/**
 * Created by ronger on 2017/6/11.
 */
@Controller
public class LoginController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String toIndex(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(@AuthenticationPrincipal Principal principal, Model model){
        final boolean[] isAdmin = {false};
        if(principal != null){
            Author author = authorService.findByUsername(principal.getName());
            model.addAttribute("nick",author.getNick());
            model.addAttribute("account",principal.getName());
            Set<Role> authorities = author.getAuthorities();
            authorities.forEach(role -> {
                if ("ADMIN".equals(role.getName())){
                    isAdmin[0] = true;
                }
            });
        }
        model.addAttribute("isAdmin",isAdmin[0]);
        return "index";
    }

}
