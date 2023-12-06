package dev.wakandaacademy.chickenapi.egg.infra;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EggSpringDataJpaRepository extends JpaRepository<Egg, UUID> {
    List<Egg> findQuantidadeOvosByChickenAndDataRegistro(Chicken chicken, LocalDate dataRegistro);
    List<Egg> findAllByDataRegistroBetween(LocalDate dataFinal, LocalDate dataFinal1);
}
