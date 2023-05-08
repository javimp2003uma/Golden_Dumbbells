package es.uma.ingsoftware.goldendumbbell;

import es.uma.ingsoftware.goldendumbbell.model.Alimento;
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

public class AlimentoTest {

    Alimento al;

    @BeforeEach
    public void init() {
        al = new Alimento();
    }

    @AfterEach
    public void terminate() {
        al = null;
    }

    @Test
    public void inicialmenteNull() {
        assertEquals(al.getName(),null);
    }


    @Test
    public void testUsuario () {
        Alimento AlimentoMock = mock(Alimento.class);

        when(AlimentoMock.getName()).thenReturn("Arroz");
        when(AlimentoMock.getComida()).thenReturn("Desayuno");
        when(AlimentoMock.getN_dieta()).thenReturn(1);
        when(AlimentoMock.getGramos()).thenReturn(50);

        //Verificar
        assertEquals("Arroz", AlimentoMock.getName());
        assertEquals("Desayuno", AlimentoMock.getComida());
        assertEquals(1, AlimentoMock.getN_dieta(), 0);
        assertEquals((Integer) 50, AlimentoMock.getGramos());

        // Verificar que el método toString funcione correctamente
        /*String expectedString = "Usuario{Identificador=null, Nombre completo='Juan', Correo='juan@example.com'}";
        assertEquals(expectedString, usuarioMock.toString());*/

    }
}

