package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import es.uma.ingsoftware.goldendumbbell.service.UsuarioService;
import oracle.jdbc.proxy.annotation.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class UsuarioTest {

    Usuario usuario;
    UsuarioService usuarioService;
    MockMvc mockMvc;

    /*
    @BeforeEach
    public void init() {
        usuario = new Usuario();
        usuarioService = new UsuarioService();
    }

    @AfterEach
    public void terminate() {
        usuario = null;
        usuarioService = null;
    } */

    /*
    @Test
    public void inicialmenteBasededatos() {

        assertNotNull(usuario.getNombreUsuario());

    } */

    @Test
    public void testGetUser () throws Exception {
        Usuario user = mock(Usuario.class);
        assertNotNull(user.getNombreUsuario());
        Usuario useraux = mock(Usuario.class);
        assertNotEquals(user.getId(),useraux.getId());
    }

    /*
    @Test
    public void inicialmenteelusariotienesusdatos() {

        assertNotEquals(usuario.getRol(), null);
        assertNotEquals(usuario.getContraseña(), null);
        assertNotEquals(usuario.getCorreo(), null);

    }*/



}

