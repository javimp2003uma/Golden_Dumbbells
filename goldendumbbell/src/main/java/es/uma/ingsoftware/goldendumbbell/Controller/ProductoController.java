package es.uma.ingsoftware.goldendumbbell.Controller;

import es.uma.ingsoftware.goldendumbbell.service.Productoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    //Yo querria que devolviera las caracterisiticas del  usuario

    @Autowired
    Productoservice productoservice;

    @RequestMapping("/tienda")

    public String listadoProductos(Model model){
        List<Producto> tienda= productoservice.getAll();

       model.addAttribute("tiendas",tienda);

        return "tienda/index";
    }

    @RequestMapping("/tienda/add")
    public String addpersona(Model model){
       //model.addAttribute("productonew",new Producto());
        return "tienda/add";
    }


    /*

    @PostMapping("/tienda/save")
    public String saveProducto(Producto p){
        productoservice.save(p);
        return "tienda/index";
    }

 */

    @RequestMapping("/tienda/edit/{id}")
    public String editpersona(Model model){
        return "tienda/edit";
    }

    @RequestMapping("/tienda/delete/{id}")
    public String deletepersona(){
        return "redirect:/tienda/index";
    }

}
