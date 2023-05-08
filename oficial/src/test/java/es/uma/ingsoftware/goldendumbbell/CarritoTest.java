package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.CarritoService;
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

public class CarritoTest {
    Carrito car;

    @BeforeEach
    public void init() {
        car = new Carrito();
    }

    @AfterEach
    public void terminate() {
        car = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(car.getNombreProducto(), null);
    }

    @Mock
    private Usuario userCar;


    @Test
    public void testCarrito() {
        Carrito carMock = mock(Carrito.class);

        when(carMock.getPrecio()).thenReturn(2.5);
        when(carMock.getId()).thenReturn(1);
        when(carMock.getCompras()).thenReturn(userCar);
        when(carMock.getNombreProducto()).thenReturn("Toalla");
        when(carMock.getCantidad()).thenReturn(10);

        //Verificar
        assertEquals(2.5, carMock.getPrecio());
        assertEquals(1, carMock.getId());
        assertEquals(userCar, carMock.getCompras());
        assertEquals("Toalla", carMock.getNombreProducto());
        assertEquals(10, carMock.getCantidad());

        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/
    }
}
