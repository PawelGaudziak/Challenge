package pl.pwn.reaktor.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pwn.reaktor.challenge.model.Firmy;
import pl.pwn.reaktor.challenge.service.FirmyService;

@Controller
public class FirmyController {

    private FirmyService firmyService;

    @Autowired
    public FirmyController(FirmyService firmyService) {
        this.firmyService = firmyService;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/dane")
    public String dane(Model model, Authentication auth){
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String email = userDetails.getUsername();
        System.out.println(email);
        // odczyt danych po emial
        Firmy firmy = firmyService.findFirma(email);
        model.addAttribute(firmy);
        return "dane";
    }


}
