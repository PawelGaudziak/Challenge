package pl.pwn.reaktor.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirmyController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/rejestracja")
    public String rejestracja(){
        return "rejestracja";

    }


    @GetMapping("/odpady")
    public String odpady(){
        return "odpady";
    }
}
