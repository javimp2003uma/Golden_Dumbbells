package es.uma.ingsoftware.goldendumbbell.Controller;

import es.uma.ingsoftware.goldendumbbell.model.Noticia;
import es.uma.ingsoftware.goldendumbbell.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @RequestMapping("/noticia")
    public String listadoNoticia (Model model) {
        List<Noticia> noticias = noticiaService.getAll();

        List<String> noticiasCuerpo = new ArrayList<>();
        for (Noticia nn : noticias) {
            noticiasCuerpo.add(nn.getInfo());
        }

        model.addAttribute("listaNoticias",noticias);
        model.addAttribute("listaCuerposNoticias",noticiasCuerpo);
        return "noticia/index";
    }

}


