package es.uma.ingsoftware.goldendumbbell.Controller;


import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    AlimentoService alimentoService;

    @RequestMapping("/dieta")
    public String listadoAlimentos(Model model) {
        List<Alimento> alimentos = alimentoService.getAll();

        model.addAttribute("listaAlimentos", alimentos);

        return "dieta/index";
    }

    @RequestMapping("/dieta")
    public String listadoAlimentosOnlyNombres (Model model) {
        List<String> nombres = alimentoService.getAllNombres();

        model.addAttribute("listaNombreAlimentos",nombres);

        return "dieta/index";
    }

    @RequestMapping("/dieta/add")
    public String addAlimento(Model model) {
        model.addAttribute("alimento", new Alimento());
        return "dieta/add";
    }

    @PostMapping("/dieta/save")
    public String saveAlimento(Alimento e) {
        alimentoService.save(e);
        return "redirect:/dieta";
    }

    @RequestMapping("/dieta/edit/{id}")
    public String editAlimento(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", alimentoService.getById(id));
        return "dieta/add";
    }

    /*@RequestMapping("/dieta/view/{id}")
    public String viewAlimento(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", alimentoService.getById(id));
        return "dieta/view";
    }
*/
    @RequestMapping("/dieta/delete/{id}")
    public String deleteAlimento(@PathVariable("id") Integer id) {
        alimentoService.delete(id);
        return "redirect:/dieta";
    }

}
