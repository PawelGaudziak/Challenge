package pl.pwn.reaktor.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pwn.reaktor.challenge.model.Odpady;
import pl.pwn.reaktor.challenge.service.OdpadyService;

import javax.validation.Valid;

@Controller
public class KPOController {

    private OdpadyService odpadyService;

    @Autowired
    public KPOController(OdpadyService odpadyService) {
        this.odpadyService = odpadyService;
    }

    @GetMapping("/KPO")
    public String index(){
        return "kpo";
    }

    @PostMapping("/KPO")
    public String dodajOdpady(@Valid @ModelAttribute Odpady odpady, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) { //sprawdzamy czy formularz jest prawidłowo wypełniony
            return "/KPO";
        }

        Odpady zapisaneOdpady = odpadyService.dodajOdpady(odpady); //dodanie KPO do bazy danych przez serwis i repository
        model.addAttribute("odpady", zapisaneOdpady); // dodanie zapisanego KPO do modelu w celu wyświetlenia go na stronie single.html
        return "KPO";
    }
}
