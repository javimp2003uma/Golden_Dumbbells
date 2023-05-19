package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
import es.uma.ingsoftware.goldendumbbell.service.ClaseService;
import es.uma.ingsoftware.goldendumbbell.service.ProductoService;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;

@Controller
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClaseService claseService;

    @Autowired
    CarritoService carritoService;

    @Autowired
    ProductoService productoService;


    @RequestMapping("/usuario")
    public String listadoUsuario(Model model) {
        List<Usuario> usuario = usuarioService.getAll();

        model.addAttribute("listaUsuario", usuario);

        return "usuario/index";
    }

    @RequestMapping("/rol")
    public String rol(Model model) {

        return "rol/rol";
    }


    @RequestMapping("/clas")
    public String clas(Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");



        return "extras/clasesdelusuario";
    }


    @PostMapping("index")
    public String loginUsuario (@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, HttpSession session,Model model) {

        List<Usuario> usu = usuarioService.getAll();
        Usuario user = null;

        for(Usuario u: usu) {
            if(u.getNombreUsuario().equalsIgnoreCase(usuario)) {
                user = u;
            }
        }

        if (user == null || !user.getContraseña().equals(contrasena)) {
            // Si las credenciales son incorrectas, se muestra un mensaje de error y se redirige a la página de inicio de sesión.
            String nombreError = "Usuario o contraseña incorrecta";
            model.addAttribute("mensajeError",nombreError);
            return "index";
        } else {
            // Si las credenciales son correctas, se establece una sesión y se redirige a la página principal.
            session.setAttribute("nameforuser",user);
            model.addAttribute("usuario", user);
            if(user.getRol().equalsIgnoreCase("Invitado")) {
                return "inicio/invitado";
            }else if(user.getRol().equalsIgnoreCase("Premium")){
                return "inicio/premium";
            }else{
                return "inicio/index";
            }
        }
    }



    @GetMapping("/inicio")
    public String verPerfilEnIndex (Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        if (usuario != null) {
            model.addAttribute("nombreAuxiliar",usuario.getNombreUsuario());
            return "inicio/index";
        } else {
            return "";
        }
    }

    @GetMapping("/extras")
    public String extras(Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        List<Carrito> aux = carritoService.getAll();
        List<Carrito> carrito = new ArrayList<>();
        if (usuario != null) {
            int i = usuario.getId();
            for(Carrito c : aux){
                if(i == c.getCompras().getId()){
                    carrito.add(c);
                }
            }

            model.addAttribute("carritoAuxiliar",carrito);
            return "extras/carritodelusuario";
        } else {
            return "inicio/index";
        }

    }



    @RequestMapping("/extras/clasedelusuario")
    public String ver(Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        List<Clase> clas = claseService.getAll();
        List<Clase> c = new ArrayList<>();
        int id =0;
        if(usuario != null) {
            id = usuario.getId();
            for (Clase h : clas) {
                for (int i = 0; i < h.getAsistentes().size(); i++) {
                    if (id == h.getAsistentes().get(i).getId()) {
                        c.add(h);
                    }
                }
            }

            model.addAttribute("clasesdelusuario", c);
            return "extras/clasedelusuario";

        }else{
            return "";
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
        return "index";
    }

    @RequestMapping("/usuario/edit/{id}")
    public String editUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("usuario", usuarioService.getById(id));
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

    @RequestMapping("/carrito/delete/{id}")
    public String deletecarrito(@PathVariable("id") String id) {
        List<Carrito> us = carritoService.getAll();
        int idi = 0;
        for(Carrito u : us){
            if(u.getNombreProducto().equalsIgnoreCase(id)){
                idi = u.getId();
            }
        }
        carritoService.delete(idi);
        return "redirect:/extras";
    }






    @RequestMapping("/añadir/{id}")
    public String addClase(@PathVariable("id") Integer id, Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");

        List<Clase> c = claseService.getAll();
        List<Usuario> usu = new ArrayList<>();
        usu.add(usuario);
        if (usuario != null) {
            int i = usuario.getId();
            for(Clase aux : c){
                if(aux.getId().equals(id)){
                    aux.setAsistentes(usu);
                    claseService.save(aux);
                }

            }

            return "redirect:/horario";
        } else {
            return "";
        }
    }

    @RequestMapping("/extras/pagar")
    public String listadoNoticia (Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        List<Carrito> t = carritoService.getAll();
        List<Carrito> aux = new ArrayList<>();
        double i = 0;

            if (usuario != null) {
                for (Carrito nn : t) {
                    if (nn.getCompras().getId().equals(usuario.getId())) {
                        aux.add(nn);
                    }
                }


                for (Carrito c : aux) {
                    i+=c.getCantidad()*c.getPrecio();
                }
                model.addAttribute("total", i);
                return "extras/pagar";
            } else {
                return "";
            }
    }

    @RequestMapping("/tienda/añadir/{id}")
    public String addCarro(@PathVariable("id") Integer id, Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        Carrito e = null;
        Producto p = new Producto();
        List<Producto> aux = productoService.getAll();
        List<Carrito> mio = carritoService.getAll();
        for(Producto a : aux){
            if(a.getId().equals(id)){
                if(a.getCantidad()> 1){
                    a.setCantidad(a.getCantidad()-1);
                    productoService.save(a);
                    p=a;
                }else{
                    p=a;
                    productoService.delete(a.getId());
                }

            }
        }
        if (usuario != null) {
            for(Carrito h : mio){
                if(h.getNombreProducto().equalsIgnoreCase(p.getNombreProducto())){
                    e = h;
                }
            }
            if(e != null){
                e.setCantidad(e.getCantidad()+1);
            }else{
                e = new Carrito();
                e.setNombreProducto(p.getNombreProducto());
                e.setCantidad(1);
                e.setPrecio(p.getPrecio());
                e.setCompras(usuario);

            }

            carritoService.save(e);


            return "redirect:/tienda";
        } else {
            return "";
        }
    }



    @RequestMapping("extras/extras/delete/{id}")
    public String deleteClase(@PathVariable("id") Integer id) {
    claseService.delete(id);
        return "redirect:/usuario";
    }


}


