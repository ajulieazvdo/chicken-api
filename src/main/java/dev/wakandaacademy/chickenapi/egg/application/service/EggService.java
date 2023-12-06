package dev.wakandaacademy.chickenapi.egg.application.service;

import dev.wakandaacademy.chickenapi.egg.application.api.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EggService {
    EggResponse criarEggs(UUID idChicken, EggRequest eggRequest);
    List<EggListResponse> buscarOvos();
    EggDetalhadoResponse buscarOvoDaGalinhaPorId(UUID idEgg);
    void deletarOvoDaGalinhaComId(UUID idEgg);
    void alterarOvoDaGalinha(UUID idChicken, UUID idEgg, EggAlteraRequest eggRequest);
    List<EggListDataResponse> buscarOvosDaGalinhaEmDataEspecifica(UUID idChicken, LocalDate dataRegistro);
    Double calcularMediaDiaria(LocalDate dataInicial, LocalDate dataFinal);
}