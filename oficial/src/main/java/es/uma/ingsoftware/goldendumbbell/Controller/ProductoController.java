package es.uma.ingsoftware.goldendumbbell.Controller;
import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
import es.uma.ingsoftware.goldendumbbell.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    CarritoService carritoService;

    @RequestMapping("/tienda")
    public String listadoProducto(Model model, HttpSession session) {
        List<Producto> producto = productoService.getAll();

        List<String> auxiliar = new ArrayList<>();
        for (Producto p : producto) {
            auxiliar.add(p.getNombreProducto());

        }

        model.addAttribute("listaProductos", producto);
        model.addAttribute("listaNombresProductos",auxiliar);
        return "tienda/index";
    }





    @RequestMapping("/tienda/añadir/{id}")
    public String addCarro(@PathVariable("id") Integer id, Model model,HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        Carrito e = null;
        Producto p = new Producto();
        List<Producto> aux = productoService.getAll();
        List<Carrito> mio = carritoService.getAll();
        for(Producto a : aux){
            if(a.getId() == id){
                p = a;
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





    @RequestMapping("/tienda/add")
    public String addProducto(Model model){
        model.addAttribute("producto", new Producto());
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
