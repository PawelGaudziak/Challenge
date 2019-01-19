package pl.pwn.reaktor.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String logowanie(){
        return "logowanie";
    }
}
