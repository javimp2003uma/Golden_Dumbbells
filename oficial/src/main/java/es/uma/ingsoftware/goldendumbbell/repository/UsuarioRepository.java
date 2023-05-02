package es.uma.ingsoftware.goldendumbbell.repository;

import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.nombreusuario =: usuario and u.contrasena = :contrasena")
    public Usuario getContrasena(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
}
