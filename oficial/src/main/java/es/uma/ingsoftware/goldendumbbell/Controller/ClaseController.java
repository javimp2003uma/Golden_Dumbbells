package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.ClaseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClaseController {

    @Autowired
    ClaseService claseService;

    @RequestMapping("/horario")
    public String listadoClases(Model model) {
        List<Clase> clase = claseService.getAll();
        List<String> aux = new ArrayList<>();
        int i = 0;
        for (Clase c : clase) {
            if(!aux.contains(c.getName())) {
                aux.add(i,c.getName());
                i++;
            }
        }
        model.addAttribute("listaClase", aux);
        return "horario/index";
    }

    @PostMapping("horario/index")
    public String horarioclases (@RequestParam("nombreclase") String nombreclase, HttpSession session, Model model) {

        List<Clase> clase = claseService.getAll();
        List<Clase> horas = new ArrayList<>();
        List<String> aux = new ArrayList<>();
        String str1Normalized = Normalizer.normalize(nombreclase, Normalizer.Form.NFD).replaceAll("\\p{M}", "");

        for(Clase c: clase) {
            String str2Normalized = Normalizer.normalize(c.getNombre(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");
            if(str2Normalized.equalsIgnoreCase(str1Normalized)) {
                horas.add(c);
                aux.add(c.getHora());
            }
        }
        model.addAttribute("listahoras",horas);
        model.addAttribute("horas",aux);
        return "horario/horas";
    }

    @RequestMapping("/horario/horas")
    public String listahora (Model model) {

        return "horario/horas";
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

}
