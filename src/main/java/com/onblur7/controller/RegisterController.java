package com.onblur7.controller;

import com.onblur7.entity.Author;
import com.onblur7.entity.InvitationCode;
import com.onblur7.entity.Role;
import com.onblur7.repository.InvitationCodeRepository;
import com.onblur7.repository.RoleRepository;
import com.onblur7.service.AuthorService;
import com.onblur7.util.MD5Tools;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ronger on 2017/6/25.
 */
@Controller
public class RegisterController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String index(){
        return "register";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request, Model model){
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> authorities = new HashSet<>();
        authorities.add(role);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Author author = new Author();
        author.setId(UUID.randomUUID().toString());
        author.setUsername(username);
        author.setNick(username);
        author.setPassword(MD5Tools.md5EncodePassword(password,author.getUsername()));
        author.setAuthorities(authorities);
        author.setCreateTime(new Date().getTime());
        author.setUpdateTime(new Date().getTime());
        authorService.save(author);
        return "redirect:/login";
    }

}
