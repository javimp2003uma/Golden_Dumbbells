package es.uma.ingsoftware.goldendumbbell.Controller;

import es.uma.ingsoftware.goldendumbbell.model.Frase;
import es.uma.ingsoftware.goldendumbbell.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FraseController {

    @Autowired
    FraseService fraseService;

    @RequestMapping("/inicio")
    public String listadoNoticia(Model model) {
        List<Frase> frases = fraseService.getAll();

        model.addAttribute("listaFrase", frases);

        return "inicio/index";
    }

}
