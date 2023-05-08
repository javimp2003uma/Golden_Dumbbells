package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Ejercicio;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EjercicioTest {
    Ejercicio ej;

    @BeforeEach
    public void init() {
        ej = new Ejercicio();
    }

    @AfterEach
    public void terminate() {
        ej = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(ej.getNombre(),null);
    }

    @Test
    public void testUsuario () {
        Ejercicio ejerMock = mock(Ejercicio.class);

        when(ejerMock.getNombre()).thenReturn("a");
        when(ejerMock.getId()).thenReturn(1);
        when(ejerMock.getRepeticiones()).thenReturn(2);
        when(ejerMock.getN_rutina()).thenReturn(1);
        when(ejerMock.getPeso()).thenReturn(60.3);

        //Verificar
        assertEquals("a", ejerMock.getNombre());
        assertEquals(1, ejerMock.getId());
        assertEquals(2, ejerMock.getRepeticiones());
        assertEquals(1, ejerMock.getN_rutina());
        assertEquals(60.3, ejerMock.getPeso());

        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/

    }
}
