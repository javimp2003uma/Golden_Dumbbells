package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/usuario")
    public String listadoUsuario(Model model) {
        List<Usuario> usuario = usuarioService.getAll();

        model.addAttribute("listaUsuario", usuario);

        return "usuario/index";
    }

    @RequestMapping("/usuario/add")
    public String addUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/add";
    }

    @PostMapping("/usuario/save")
    public String saveUsuario(Usuario e) {
       usuarioService.save(e);
        return "redirect:/usuario";
    }

    @RequestMapping("/usuario/edit/{id}")
    public String editUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", usuarioService.getById(id));
        return "usuario/add";
    }
/*
    @RequestMapping("/usuario/view/{id}")
    public String viewUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("alimento", usuarioService.getById(id));
        return "usuario/view";
    }
*/
    @RequestMapping("/usuario/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return "redirect:/usuario";
    }
}
