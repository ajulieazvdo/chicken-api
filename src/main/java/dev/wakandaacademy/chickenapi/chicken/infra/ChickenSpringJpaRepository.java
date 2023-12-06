package dev.wakandaacademy.chickenapi.chicken.infra;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChickenSpringJpaRepository extends JpaRepository<Chicken, UUID> {
}