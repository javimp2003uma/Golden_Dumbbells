package es.uma.ingsoftware.goldendumbbell.Controller;


import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @RequestMapping("/carrito")
    public String carritodecompra (Model model) {
        List<Carrito> carrito = carritoService.getAll();

        model.addAttribute("listaCarrito", carrito);

        return "carrito/index";
    }
}
