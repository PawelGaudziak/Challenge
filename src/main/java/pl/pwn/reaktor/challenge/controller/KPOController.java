package pl.pwn.reaktor.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KPOController {

    @GetMapping("/KPO")
    public String index(){
        return "kpo";
    }
}
