package dev.wakandaacademy.chickenapi.chicken.application.repository;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;

import java.util.List;
import java.util.UUID;

public interface ChickenRepository {
    Chicken criarGalinha(Chicken chicken);
    List<Chicken> listarTodasGalinhas();
    Chicken listarUmaGalinhaPorId(UUID idChicken);
    void deletarUmaGalinha(Chicken chicken);
}