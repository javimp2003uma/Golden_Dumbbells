package es.uma.ingsoftware.goldendumbbell.Controller;


import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @GetMapping("/carrito")
    public String Carritodecompra (Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("nameforuser");
        List<Carrito> carrito = carritoService.getAll();
        List<Carrito> car = new ArrayList<>();
        int i = 0;
        for (Carrito c : carrito) {
            if(usuario.getId() == c.getCompras().getId()) {
                car.add(i,c);
                i++;
            }
        }
        model.addAttribute("listaCarrito", car);
        return "carrito/index";
    }
}
