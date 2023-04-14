package es.uma.ingsoftware.goldendumbbell.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticiaController {

    @RequestMapping("/noticia")
    //Lista de noticias

    public String listadoNoticias(){
        return "noticia/index";
    }

}
