package dev.wakandaacademy.chickenapi.egg.application.repository;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EggRepository {
    Egg criarEggs(Egg egg);
    List<Egg> buscarOvos();
    Egg buscarOvoDaGalinhaPorId(UUID idEgg);
    void deletaOvo(Egg egg);
    List<Egg> buscarOvosDaGalinhaEmDataEspecifica(Chicken chicken, LocalDate dataRegistro);
    List<Egg> buscarTodosOvosPorData(LocalDate dataInicial, LocalDate dataFinal);
}