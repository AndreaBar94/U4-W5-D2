package andrea.GestionePrenotazioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @GetMapping("")
    public String home(@RequestParam(defaultValue = "it") String lang) {
        if (lang.equals("it")) {
            return "Benvenuto, a seguire le regole per la prenotazione: ...";
        } else {
            return "Welcome, here you are our reservation rules: ...";
        }
    }
}
