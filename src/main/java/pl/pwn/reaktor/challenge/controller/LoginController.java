package pl.pwn.reaktor.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String logowanie(){
        return "logowanie";
    }

//    @GetMapping("/logout")
//    public String logout(){
//        return "redirect:/";
//    }

}
