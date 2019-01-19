package pl.pwn.reaktor.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pwn.reaktor.challenge.model.Firmy;
import pl.pwn.reaktor.challenge.repository.FirmyRepository;
import pl.pwn.reaktor.challenge.service.FirmyService;

import javax.validation.Valid;

@Controller
public class RejestracjaController {

    FirmyService firmyService;
    FirmyRepository firmyRepository;

    @Autowired
    public RejestracjaController(FirmyService firmyService, FirmyRepository firmyRepository) {
        this.firmyService = firmyService;
        this.firmyRepository = firmyRepository;
    }

    @GetMapping("/rejestracja")
    public String rejestracja(Model model){
        Firmy firmy = new Firmy();
        model.addAttribute("firmy",firmy);
        return "rejestracja";
    }

    @PostMapping("/rejestracja")
    public String rejestracja(@Valid @ModelAttribute Firmy firmy, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("wwww");
            // wyświetlenie strony gdy znajdziemy jakieś błędy walidacyjne
            return "rejestracja";
        }
        System.out.println("XXX");
        Firmy firmaSaved = firmyService.addFirma(firmy);


        return "rejestracja";
    }

}
