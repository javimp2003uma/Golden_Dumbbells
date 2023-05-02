package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @RequestMapping("/tienda")
    public String listadoProducto(Model model) {
        List<Producto> producto = productoService.getAll();

        model.addAttribute("listaProductos", producto);

        return "tienda/index";
    }

    @RequestMapping("/tienda/add")
    public String addProducto(Model model){
        model.addAttribute("prodcuto", new Producto());
        return "/tienda/add";
    }

    @PostMapping("/tienda/save")
    public String saveProducto(Producto e){
        productoService.save(e);
        return "redirect:/tienda";
    }

    @RequestMapping("/tienda/edit/{id}")
    public String editProducto(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("producto", productoService.getById(id));
        return "tienda/add";
    }

    @RequestMapping("/tienda/delete/{id}")
    public String deleteProducto(@PathVariable("id") Integer id) {
        productoService.delete(id);
        return "redirect:/tienda";
    }
}
