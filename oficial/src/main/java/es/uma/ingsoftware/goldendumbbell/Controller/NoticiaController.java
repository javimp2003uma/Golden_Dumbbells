package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Noticia;
import es.uma.ingsoftware.goldendumbbell.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @RequestMapping("/noticia")
    public String listadoNoticia(Model model) {
        List<Noticia> noticia = noticiaService.getAll();

        model.addAttribute("listaNoticias", noticia);

        return "noticia/index";
    }

    @RequestMapping("/noticia/add")
    public String addNoticia(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "noticia/add";
    }

    @PostMapping("/noticia/save")
    public String saveNoticia(Noticia e) {
        noticiaService.save(e);
        return "redirect:/";
    }

    @RequestMapping("/noticia/edit/{id}")
    public String editNoticia(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("noticia", noticiaService.getById(id));
        return "noticia/add";
    }
/*
    @RequestMapping("/noticia/view/{id}")
    public String viewNoticia(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("noticia", noticiaService.getById(id));
        return "noticia/view";
    }
*/
    @RequestMapping("/noticia/delete/{id}")
    public String deleteNoticia(@PathVariable("id") Integer id) {
        noticiaService.delete(id);
        return "redirect:/noticia";
    }
}
