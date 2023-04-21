package es.uma.ingsoftware.goldendumbbell.Controller;

import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.model.Ejercicio;
import es.uma.ingsoftware.goldendumbbell.service.AlimentoService;
import es.uma.ingsoftware.goldendumbbell.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EjercicioController {

    @Autowired
    EjercicioService ejercicioService;

    @RequestMapping("/rutina")
    public String listadoEjercicios(Model model) {
        List<Ejercicio> ejercicio = ejercicioService.getAll();

        model.addAttribute("listaEjercicios", ejercicio);

        return "rutina/index";
    }

    @RequestMapping("/rutina/add")
    public String addEjercicio(Model model) {
        model.addAttribute("rutina", new Ejercicio());
        return "rutina/add";
    }

    @PostMapping("/rutina/save")
    public String saveEjercicio(Ejercicio e) {
        ejercicioService.save(e);
        return "redirect:/rutina";
    }

    @RequestMapping("/rutina/edit/{id}")
    public String editEjercicio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", ejercicioService.getById(id));
        return "rutina/add";
    }

    @RequestMapping("/dieta/view/{id}")
    public String vieweEjercicio(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", ejercicioService.getById(id));
        return "rutina/view";
    }

    @RequestMapping("/rutina/delete/{id}")
    public String deleteEjercicio(@PathVariable("id") Integer id) {
        ejercicioService.delete(id);
        return "redirect:/rutina";
    }
}
