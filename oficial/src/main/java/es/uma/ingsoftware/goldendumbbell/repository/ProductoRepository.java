package es.uma.ingsoftware.goldendumbbell.repository;

import es.uma.ingsoftware.goldendumbbell.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
