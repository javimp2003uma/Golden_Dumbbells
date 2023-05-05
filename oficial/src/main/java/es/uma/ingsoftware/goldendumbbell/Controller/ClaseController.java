package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClaseController {

    @Autowired
    ClaseService claseService;

    @RequestMapping("/horario")
    public String listadoClases(Model model) {
        List<Clase> clase = claseService.getAll();
        List<String> aux = new ArrayList<>();
        int i=0;
        for(Clase c : clase){
            if(!aux.contains(c.getName())){
                aux.add(i,c.getName());
                i++;
            }
        }
        model.addAttribute("listaClase", aux);

        return "horario/index";
    }

    @RequestMapping("/horario/add")
    public String addClase(Model model) {
            model.addAttribute("clase", new Clase());
            return "horario/add";
        }

        @PostMapping("/horario/save")
        public String saveClase(Clase e) {
            claseService.save(e);
            return "redirect:/horario";
        }

        @RequestMapping("/horario/edit/{id}")
        public String editClase(@PathVariable("id") Integer id, Model model) {
            model.addAttribute("clase", claseService.getById(id));
            return "horario/add";
        }


        @RequestMapping("/horario/delete/{id}")
        public String deleteClase(@PathVariable("id") Integer id) {
            claseService.delete(id);
            return "redirect:/horario";
        }
}
