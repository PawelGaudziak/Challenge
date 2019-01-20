package pl.pwn.reaktor.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pwn.reaktor.challenge.model.Firmy;
import pl.pwn.reaktor.challenge.model.Odpady;
import pl.pwn.reaktor.challenge.service.FirmyService;
import pl.pwn.reaktor.challenge.service.OdpadyService;

@Controller
public class FirmyController {

    private FirmyService firmyService;
    private OdpadyService odpadyService;

    @Autowired
    public FirmyController(FirmyService firmyService, OdpadyService odpadyService) {
        this.firmyService = firmyService;
        this.odpadyService = odpadyService;
    }

    @GetMapping("/index")
    public String index(Model model){

        Double odpadySuma = odpadyService.sumujOdpady();

        model.addAttribute("masa", odpadySuma);
        System.out.println(odpadySuma);

        return "index";
    }

    @GetMapping("/")
    public String home(Model model){

        Double odpadySuma = odpadyService.sumujOdpady();

        model.addAttribute("masa", odpadySuma);
        System.out.println(odpadySuma);

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
