package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.repository.UsuarioRepository;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsuarioController {

    UsuarioRepository usuarioRepository;


    @Autowired
    UsuarioService usuarioService;


    @RequestMapping("/usuario")
    public String listadoUsuario(Model model) {
        List<Usuario> usuario = usuarioService.getAll();

        model.addAttribute("listaUsuario", usuario);

        return "usuario/index";
    }

    @PostMapping("index")
    public String loginUsuario (@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, HttpSession session,Model model) {

        List<Usuario> usu = usuarioService.getAll();
        Usuario user = new Usuario();

        for(Usuario u: usu){
            if(u.getNombreUsuario().equalsIgnoreCase(usuario)){
                user = u;
            }
        }

        if (user == null || !user.getContraseña().equals(contrasena)) {
            // Si las credenciales son incorrectas, se muestra un mensaje de error y se redirige a la página de inicio de sesión.
            session.setAttribute("mensajeError", "Usuario o contraseña incorrectos.");
            return "index";
        } else {
            // Si las credenciales son correctas, se establece una sesión y se redirige a la página principal.
            model.addAttribute("usuario", user);
            return "inicio/index";
        }
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
