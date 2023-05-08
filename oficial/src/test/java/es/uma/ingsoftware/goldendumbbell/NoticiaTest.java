package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.model.Noticia;
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

public class NoticiaTest {

    Noticia nt;

    @BeforeEach
    public void init() {
        nt = new Noticia();
    }

    @AfterEach
    public void terminate() {
        nt = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(nt.getTitulo(),null);
    }

    @Test
    public void testNoticia () {
        Noticia noticiaTest = mock(Noticia.class);

        when(noticiaTest.getTitulo()).thenReturn("Nueva maquina");
        when(noticiaTest.getFechadpublicacion()).thenReturn(new Date(2003,4,23));
        when(noticiaTest.getInfo()).thenReturn("Ha hacer prensa");

        //Verificar
        assertEquals("Nueva maquina", noticiaTest.getTitulo());
        assertEquals(new Date(2003,4,23),noticiaTest.getFechadpublicacion());
        assertEquals("Ha hacer prensa", noticiaTest.getInfo());
        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/

    }
}

