package es.uma.ingsoftware.goldendumbbell.repository;


import es.uma.ingsoftware.goldendumbbell.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuariorepository extends JpaRepository<Usuario,Integer> {

}
