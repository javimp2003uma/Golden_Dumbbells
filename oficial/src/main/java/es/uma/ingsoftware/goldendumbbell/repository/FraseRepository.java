package es.uma.ingsoftware.goldendumbbell.repository;

import es.uma.ingsoftware.goldendumbbell.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraseRepository extends JpaRepository<Frase, Integer> {
}
