package pl.pwn.reaktor.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RejestracjaController {

    @GetMapping("/rejestracja")
    public String rejestracja(){
        return "rejestracja";

    }
}
