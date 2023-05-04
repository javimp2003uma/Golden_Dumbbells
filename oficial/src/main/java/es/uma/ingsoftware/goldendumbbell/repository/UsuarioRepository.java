package es.uma.ingsoftware.goldendumbbell.repository;

import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

   /* @Query("select u from Usuario  u where u.nombreusuario =: nombreUsuario")
    Usuario findByNombreusuario (@Param("nombreUsuario") String nombreUsuario);

    */

}
