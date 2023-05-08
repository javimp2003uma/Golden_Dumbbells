package es.uma.ingsoftware.goldendumbbell.Controller;


import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.model.Ejercicio;
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
    public String listadoAlimentos (Model model) {

        return "dieta/index";
    }

    @RequestMapping("/dieta/dietapremium")
    public String premiumdieta(Model model) {

        return "dieta/dietapremium";
    }

    @RequestMapping("/dieta/dietauno")
    public String Dietauno(Model model){
        List<Alimento> alimentos = alimentoService.getAll();
        List<Alimento> desayuno= new ArrayList<>();
        List<Alimento> almuerzo= new ArrayList<>();
        List<Alimento> snack= new ArrayList<>();
        List<Alimento> cena= new ArrayList<>();
        int i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 1 && a.getComida().equalsIgnoreCase("Desayuno")){
                desayuno.add(i,a);
                i++;
            }
            model.addAttribute("desayunouno", desayuno);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 1 && a.getComida().equalsIgnoreCase("Almuerzo")){
                almuerzo.add(i,a);
                i++;
            }
            model.addAttribute("almuerzouno", almuerzo);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 1 && a.getComida().equalsIgnoreCase("Snack")){
                snack.add(i,a);
                i++;
            }
            model.addAttribute("snackuno", snack);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 1 && a.getComida().equalsIgnoreCase("Cena")){
                cena.add(i,a);
                i++;
            }
            model.addAttribute("cenauno", cena);
        }
        return "dieta/dietauno";
    }


    @RequestMapping("/dieta/dietados")
    public String Dietados(Model model){
        List<Alimento> alimentos = alimentoService.getAll();
        List<Alimento> desayuno= new ArrayList<>();
        List<Alimento> almuerzo= new ArrayList<>();
        List<Alimento> snack= new ArrayList<>();
        List<Alimento> cena= new ArrayList<>();
        int i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 2 && a.getComida().equalsIgnoreCase("Desayuno")){
                desayuno.add(i,a);
                i++;
            }
            model.addAttribute("desayunodos", desayuno);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 2 && a.getComida().equalsIgnoreCase("Almuerzo")){
                almuerzo.add(i,a);
                i++;
            }
            model.addAttribute("almuerzodos", almuerzo);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 2 && a.getComida().equalsIgnoreCase("Snack")){
                snack.add(i,a);
                i++;
            }
            model.addAttribute("snackdos", snack);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 2 && a.getComida().equalsIgnoreCase("Cena")){
                cena.add(i,a);
                i++;
            }
            model.addAttribute("cenados", cena);
        }
        return "dieta/dietados";
    }

    @RequestMapping("/dieta/dietatres")
    public String Dietatres(Model model){
        List<Alimento> alimentos = alimentoService.getAll();
        List<Alimento> desayuno= new ArrayList<>();
        List<Alimento> almuerzo= new ArrayList<>();
        List<Alimento> snack= new ArrayList<>();
        List<Alimento> cena= new ArrayList<>();
        int i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 3 && a.getComida().equalsIgnoreCase("Desayuno")){
                desayuno.add(i,a);
                i++;
            }
            model.addAttribute("desayunotres", desayuno);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 3 && a.getComida().equalsIgnoreCase("Almuerzo")){
                almuerzo.add(i,a);
                i++;
            }
            model.addAttribute("almuerzotres", almuerzo);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 3 && a.getComida().equalsIgnoreCase("Snack")){
                snack.add(i,a);
                i++;
            }
            model.addAttribute("snacktres", snack);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 3 && a.getComida().equalsIgnoreCase("Cena")){
                cena.add(i,a);
                i++;
            }
            model.addAttribute("cenatres", cena);
        }
        return "dieta/dietatres";
    }

    @RequestMapping("/dieta/dietacuatro")
    public String Dietacuatro(Model model){
        List<Alimento> alimentos = alimentoService.getAll();
        List<Alimento> desayuno= new ArrayList<>();
        List<Alimento> almuerzo= new ArrayList<>();
        List<Alimento> snack= new ArrayList<>();
        List<Alimento> cena= new ArrayList<>();
        int i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 4 && a.getComida().equalsIgnoreCase("Desayuno")){
                desayuno.add(i,a);
                i++;
            }
            model.addAttribute("desayunocuatro", desayuno);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 4 && a.getComida().equalsIgnoreCase("Almuerzo")){
                almuerzo.add(i,a);
                i++;
            }
            model.addAttribute("almuerzocuatro", almuerzo);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 4 && a.getComida().equalsIgnoreCase("Snack")){
                snack.add(i,a);
                i++;
            }
            model.addAttribute("snackcuatro", snack);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 4 && a.getComida().equalsIgnoreCase("Cena")){
                cena.add(i,a);
                i++;
            }
            model.addAttribute("cenacuatro", cena);
        }
        return "dieta/dietacuatro";
    }

    @RequestMapping("/dieta/dietacinco")
    public String Dietacinco(Model model){
        List<Alimento> alimentos = alimentoService.getAll();
        List<Alimento> desayuno= new ArrayList<>();
        List<Alimento> almuerzo= new ArrayList<>();
        List<Alimento> snack= new ArrayList<>();
        List<Alimento> cena= new ArrayList<>();
        int i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 5 && a.getComida().equalsIgnoreCase("Desayuno")){
                desayuno.add(i,a);
                i++;
            }
            model.addAttribute("desayunocinco", desayuno);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 5 && a.getComida().equalsIgnoreCase("Almuerzo")){
                almuerzo.add(i,a);
                i++;
            }
            model.addAttribute("almuerzocinco", almuerzo);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 5 && a.getComida().equalsIgnoreCase("Snack")){
                snack.add(i,a);
                i++;
            }
            model.addAttribute("snackcinco", snack);
        }

        i= 0;
        for (Alimento a : alimentos) {
            if(a.getN_dieta() == 5 && a.getComida().equalsIgnoreCase("Cena")){
                cena.add(i,a);
                i++;
            }
            model.addAttribute("cenacinco", cena);
        }
        return "dieta/dietacinco";
    }

   /* @RequestMapping("/dieta/verNombres")
    public String listadoAlimentosOnlyNombres (Model model) {
        List<String> nombres = alimentoService.getAllNombres();
        double m = alimentoService.getMediaGramos();

        model.addAttribute("listaNombreAlimentos",nombres);
        model.addAttribute("mediaGrAlim",m);

        return "dieta/verNombres";
    }
    */


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
    @RequestMapping("/dieta/recetas")
    public String recetas(Model model) {

        return "dieta/recetas";
    }

    @RequestMapping("/dieta/delete/{id}")
    public String deleteAlimento(@PathVariable("id") Integer id) {
        alimentoService.delete(id);
        return "redirect:/dieta";
    }

}
