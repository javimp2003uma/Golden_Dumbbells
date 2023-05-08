package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.Controller.ClaseController;
import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClaseTest {
    Clase car;

    @BeforeEach
    public void init() {
        car = new Clase();
    }

    @AfterEach
    public void terminate() {
        car = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(car.getName(), null);
    }

    @Mock
    private List<Usuario> asAux;


    @Test
    public void testCarrito() {
        Clase claseMock = mock(Clase.class);

        when(claseMock.getAsistentes()).thenReturn(asAux);
        when(claseMock.getId()).thenReturn(1);
        when(claseMock.getName()).thenReturn("NombreClase");
        when(claseMock.getHora()).thenReturn("HoraPrueba");
        when(claseMock.getN_usuario()).thenReturn(2);

        assertEquals(asAux, claseMock.getAsistentes());
        assertEquals(1, claseMock.getId());
        assertEquals("NombreClase", claseMock.getName());
        assertEquals("HoraPrueba", claseMock.getHora());
        assertEquals(2, claseMock.getN_usuario());

        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/
    }
}
