package es.uma.ingsoftware.goldendumbbell.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PaginaInicio {


    @RequestMapping("/inicio")
    public String listado (Model model) {

        return "inicio/index";
    }

    @RequestMapping("/inicio/premium")
    public String listadopremium(Model model) {

        return "inicio/premium";
    }

    @RequestMapping("/inicio/invitado")
    public String listadoinvitado(Model model) {

        return "inicio/invitado";
    }

}
