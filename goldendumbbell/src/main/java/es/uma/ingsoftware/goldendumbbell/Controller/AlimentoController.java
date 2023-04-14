package es.uma.ingsoftware.goldendumbbell.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlimentoController {

    @RequestMapping("/dieta")
    //Yo querria que devolviera las caracterisiticas del  usuario

    public String listadoAlimentos(){
        return "dieta/index";
    }

}

