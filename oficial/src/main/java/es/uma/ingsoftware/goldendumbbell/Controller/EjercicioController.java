package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Ejercicio;
import es.uma.ingsoftware.goldendumbbell.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EjercicioController {

    @Autowired
    EjercicioService ejercicioService;

    @RequestMapping("/rutina")
    public String listadobotones(Model model) {

        return "rutina/index";
    }

    @RequestMapping("/rutina/rutinapremium")
    public String premiumbotones(Model model) {

        return "rutina/rutinapremium";
    }

    @RequestMapping("/rutina/videos")
    public String videos(Model model) {

        return "rutina/videos";
    }

    @RequestMapping("/rutina/rutinauno")
    public String listaRutinauno(Model model){
        List<Ejercicio> ejercicios = ejercicioService.getAll();
        List<Ejercicio> ejer= new ArrayList<>();
        int i= 0;
        for (Ejercicio p : ejercicios) {
            if(p.getN_rutina() == 1){
               ejer.add(i,p);
               i++;
            }
            model.addAttribute("rutinauno", ejer);
        }

        return "rutina/rutinauno";
    }

    @RequestMapping("/rutina/rutinados")
    public String listaRutinados(Model model){
        List<Ejercicio> ejercicios = ejercicioService.getAll();
        List<Ejercicio> ejer= new ArrayList<>();
        int i= 0;
        for (Ejercicio p : ejercicios) {
            if(p.getN_rutina() == 2){
                ejer.add(i,p);
                i++;
            }
            model.addAttribute("rutinados", ejer);
        }

        return "rutina/rutinados";
    }

    @RequestMapping("/rutina/rutinatres")
    public String listaRutinatres(Model model){
        List<Ejercicio> ejercicios = ejercicioService.getAll();
        List<Ejercicio> ejer= new ArrayList<>();
        int i= 0;
        for (Ejercicio p : ejercicios) {
            if(p.getN_rutina() == 3){
                ejer.add(i,p);
                i++;
            }
            model.addAttribute("rutinatres", ejer);
        }

        return "rutina/rutinatres";
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

    @RequestMapping("/rutina/delete/{id}")
    public String deleteEjercicio(@PathVariable("id") Integer id) {
        ejercicioService.delete(id);
        return "redirect:/rutina";
    }


}

