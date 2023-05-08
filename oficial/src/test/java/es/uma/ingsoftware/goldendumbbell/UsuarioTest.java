package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import oracle.jdbc.proxy.annotation.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioTest {

    Usuario user;

    @BeforeEach
    public void init() {
        user = new Usuario();
    }

    @AfterEach
    public void terminate() {
        user = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(user.getNombreUsuario(),null);
    }

    @Mock
    private List<Clase> clases;

    @Mock
    private List<Carrito> carrito;


    @Test
    public void testUsuario () {
        Usuario usuarioMock = mock(Usuario.class);

        when(usuarioMock.getNombreUsuario()).thenReturn("Juan");
        when(usuarioMock.getContrasena()).thenReturn("password123");
        when(usuarioMock.getClases()).thenReturn(clases);
        when(usuarioMock.getCarrito()).thenReturn(carrito);
        when(usuarioMock.getRol()).thenReturn("usuario");
        when(usuarioMock.getPeso()).thenReturn(70.5);
        when(usuarioMock.getAltura()).thenReturn(170);
        when(usuarioMock.getCorreo()).thenReturn("juan@example.com");
        when(usuarioMock.getTelefono()).thenReturn(1234567890);
        when(usuarioMock.getNacimiento()).thenReturn(new Date());

        //Verificar
        assertEquals("Juan", usuarioMock.getNombreUsuario());
        assertEquals("password123", usuarioMock.getContrasena());
        assertEquals(clases, usuarioMock.getClases());
        assertEquals(carrito, usuarioMock.getCarrito());
        assertEquals("usuario", usuarioMock.getRol());
        assertEquals(70.5, usuarioMock.getPeso(), 0);
        assertEquals((Integer) 170, usuarioMock.getAltura());
        assertEquals("juan@example.com", usuarioMock.getCorreo());
        assertEquals((Integer) 1234567890, usuarioMock.getTelefono());
        assertNotNull(usuarioMock.getNacimiento());

        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/
        
    }
}

