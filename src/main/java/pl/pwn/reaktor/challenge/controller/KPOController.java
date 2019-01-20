package pl.pwn.reaktor.challenge.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pwn.reaktor.challenge.model.Firmy;
import pl.pwn.reaktor.challenge.model.Odpady;
import pl.pwn.reaktor.challenge.service.FirmyService;
import pl.pwn.reaktor.challenge.service.OdpadyService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KPOController {

    private OdpadyService odpadyService;
    private FirmyService firmyService;

    @Autowired
    public KPOController(OdpadyService odpadyService, FirmyService firmyService) {
        this.odpadyService = odpadyService;
        this.firmyService = firmyService;
    }

    @GetMapping("/kpo")
    public String index(Model model){

        model.addAttribute("kpo", new Odpady());
        return "kpo";
    }

    @GetMapping("/usunKPO")
    public String usunKPO() {

        return "/usunKPO";
    }

    @GetMapping("/usunKPO/{nip}")
    public String view(@PathVariable(name = "nip") String nip, Model model) {

    List<Odpady> odpadyByNip = odpadyService.findAllByNip(nip);
    model.addAttribute("odpady", odpadyByNip);

        return "/usunKPO";
    }

    @PostMapping("/kpo")
    public String dodajOdpady(@Valid @ModelAttribute Odpady odpady, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) { //sprawdzamy czy formularz jest prawidłowo wypełniony
            return "/kpo";
        }

        Odpady zapisaneOdpady = odpadyService.dodajOdpady(odpady); //dodanie KPO do bazy danych przez serwis i repository
        model.addAttribute("kpo", zapisaneOdpady); // dodanie zapisanego KPO do modelu w celu wyświetlenia go na stronie single.html
        return "/kpo";
    }
}
