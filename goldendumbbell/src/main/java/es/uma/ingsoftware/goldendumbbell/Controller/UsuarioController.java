package es.uma.ingsoftware.goldendumbbell.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @RequestMapping("/usuario")
    //Yo querria que devolviera las caracterisiticas del  usuario

    public String listadoUsuarios(){
        return "usuario/index";
    }

    @RequestMapping("/usuarios/add")
    public String addpersona(){
        return "usuario/add";
    }

    @RequestMapping("/usuarios/edit")
    public String editpersona(){
        return "usuario/edit";
    }

    @RequestMapping("/usuarios/delete")
    public String deletepersona(){
        return "redirect:usuario/index";
    }

}
