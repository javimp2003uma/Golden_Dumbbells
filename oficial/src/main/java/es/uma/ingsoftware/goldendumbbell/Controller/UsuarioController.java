package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.repository.UsuarioRepository;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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

        for(Usuario u: usu) {
            if(u.getNombreUsuario().equalsIgnoreCase(usuario)) {
                user = u;
            }
        }

        if (user == null || !user.getContraseña().equals(contrasena)) {
            // Si las credenciales son incorrectas, se muestra un mensaje de error y se redirige a la página de inicio de sesión.
            session.setAttribute("mensajeError", "Usuario o contraseña incorrectos.");
            return "index";
        } else {
            // Si las credenciales son correctas, se establece una sesión y se redirige a la página principal.
            session.setAttribute("nameforuser",user);
            model.addAttribute("usuario", user);
            if(user.getRol().equalsIgnoreCase("Invitado")){
                return "inicio/invitado";
            }else if(user.getRol().equalsIgnoreCase("Premium")){
                return "inicio/premium";
            }else{
                return "inicio/index";
            }
        }
    }

    @GetMapping("/usuario")
    public String verPerfil (Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        if (usuario != null) {
            model.addAttribute("usuarioNameUse",usuario);
            model.addAttribute("nombreAuxiliar",usuario.getNombreUsuario());
            model.addAttribute("contrasenaAuxiliar",usuario.getContraseña());
            return "usuario/index";
        } else {
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
