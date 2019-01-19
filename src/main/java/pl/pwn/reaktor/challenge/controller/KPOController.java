package pl.pwn.reaktor.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class KPOController {

    @GetMapping("/KPO")
    public String index(){
        return "kpo";
    }
}
