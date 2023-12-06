package dev.wakandaacademy.chickenapi.chicken.application.service;

import dev.wakandaacademy.chickenapi.chicken.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ChickenService {
    ChickenResponse criarGalinha(ChickenRequest chickenRequest);
    List<ChickenListResponse> listarTodasGalinhas();
    ChickenDetalhadoResponse listarUmaGalinhaPorId(UUID idChicken);
    void deletarUmaGalinhaPorId(UUID idChicken);
    void alterarUmaGalinha(UUID idChicken, ChickenAlteraRequest chickenRequest);
}