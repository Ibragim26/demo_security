package ru.looktook.demo_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.looktook.demo_security.domain.User;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        if(user != null){
            model.addAttribute("user", user.getUsername());
            return "index";
        }
        model.addAttribute("user", "");
        return "index";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/user")
    public String forUser(){
        return "foruser";
    }
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String forAdmin(){
        return "foradmin";
    }

}
