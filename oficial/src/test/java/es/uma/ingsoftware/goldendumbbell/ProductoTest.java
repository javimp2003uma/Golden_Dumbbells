package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.Controller.ProductoController;
import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.ProductoService;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductoTest {

    Producto product;
    ProductoService productoService;
    ProductoController productoController;
    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        product = new Producto();
    }

    @AfterEach
    public void terminate() {
        product = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(product.getNombreProducto(), null);
    }

    @Test
    public void testProducto() {
        Producto productoMock = mock(Producto.class);

        when(productoMock.getNombreProducto()).thenReturn("Manzana");
        when(productoMock.getId()).thenReturn(1);
        when(productoMock.getPrecio()).thenReturn(4.3);
        when(productoMock.getCantidad()).thenReturn(5);
        //Verificar
        assertEquals("Manzana", productoMock.getNombreProducto());
        assertEquals(1, productoMock.getId());
        assertEquals(4.3, productoMock.getPrecio());
        assertEquals(5, productoMock.getCantidad());


        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/
    }
}
