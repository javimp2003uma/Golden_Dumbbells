package es.uma.ingsoftware.goldendumbbell.Controller;

import es.uma.ingsoftware.goldendumbbell.model.Noticia;
import es.uma.ingsoftware.goldendumbbell.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @RequestMapping("/noticia")
    public String listadoNoticia(Model model){
        List<Noticia> noticias = noticiaService.getAll();

        model.addAttribute("listaNoticias",noticias);
        return "noticia/index";
    }

}


