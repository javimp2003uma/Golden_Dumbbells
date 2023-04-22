package es.uma.ingsoftware.goldendumbbell.repository;

import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}

