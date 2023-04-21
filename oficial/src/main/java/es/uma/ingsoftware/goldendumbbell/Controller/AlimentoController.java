package es.uma.ingsoftware.goldendumbbell.Controller;


import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    AlimentoService alimentoService;

    @RequestMapping("/tienda")
    public String listadoEditorials(Model model) {
        List<Alimento> alimento = alimentoService.getAll();

        model.addAttribute("listaAlimentos", alimento);

        return "tienda/index";
    }

    @RequestMapping("/tienda/add")
    public String addEditorial(Model model) {
        model.addAttribute("alimento", new Alimento());
        return "tienda/add";
    }

    @PostMapping("/tienda/save")
    public String saveEditorial(Alimento e) {
        alimentoService.save(e);
        return "redirect:/tienda";
    }

    @RequestMapping("/tienda/edit/{id}")
    public String editEditorial(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("aliemnto", alimentoService.getById(id));
        return "tienda/add";
    }

    @RequestMapping("/editoriales/view/{id}")
    public String viewEditorial(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", alimentoService.getById(id));
        return "editoriales/view";
    }

    @RequestMapping("/editoriales/delete/{id}")
    public String deleteEditorial(@PathVariable("id") Integer id) {
        alimentoService.delete(id);
        return "redirect:/editoriales";
    }

}
