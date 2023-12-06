package dev.wakandaacademy.chickenapi.egg.application.api;

import dev.wakandaacademy.chickenapi.egg.application.service.EggService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EggRestController implements EggAPI {
    private final EggService eggService;
    @Override
    public EggResponse criarOvo(UUID idChicken, EggRequest eggRequest) {
        log.info("[inicia] EggRestController - criarOvo");
        EggResponse eggs = eggService.criarEggs(idChicken, eggRequest);
        log.info("[finaliza] EggRestController - criarOvo");
        return eggs;
    }

    @Override
    public List<EggListResponse> buscarOvos() {
        log.info("[inicia] EggRestController - buscarOvos");
        List<EggListResponse> ovos = eggService.buscarOvos();
        log.info("[finaliza] EggRestController - buscarOvos ");
        return ovos;
    }

    @Override
    public EggDetalhadoResponse buscarOvoDaGalinhaComId(UUID idEgg) {
        log.info("[inicia] EggRestController - buscaOvoDaGalinhaComId");
        log.info("[idEgg] {}", idEgg);
        EggDetalhadoResponse egg = eggService.buscarOvoDaGalinhaPorId(idEgg);
        log.info("[finaliza] EggRestController - buscaOvoDaGalinhaComId");
        return egg;
    }

    @Override
    public void deletarOvoDaGalinhaComId(UUID idEgg) {
        log.info("[inicia] EggRestController - deletarOvoDaGalinhaComId");
        log.info("[idEgg] {}", idEgg);
        eggService.deletarOvoDaGalinhaComId(idEgg);
        log.info("[finaliza] EggRestController - deletarOvoDaGalinhaComId");
    }

    @Override
    public void alterarOvoDaGalinha(UUID idChicken,UUID idEgg, EggAlteraRequest eggRequest) {
        log.info("[inicia] EggRestController - alterarOvoDaGalinha");
        log.info("[idChicken] {} - [idEgg] {}", idChicken, idEgg);
        eggService.alterarOvoDaGalinha(idChicken, idEgg, eggRequest);
        log.info("[finaliza] EggRestController - alterarOvoDaGalinha");
    }

    @Override
    public List<EggListDataResponse> buscarOvosDaGalinhaEmDataEspecifica(UUID idChicken, LocalDate dataRegistro) {
        log.info("[inicia] EggRestController - buscaOvosDaGalinhaEmDataEspecifica");
        List<EggListDataResponse> ovos = eggService.buscarOvosDaGalinhaEmDataEspecifica(idChicken, dataRegistro);
        log.info("[finaliza] EggRestController - buscaOvosDaGalinhaEmDataEspecifica ");
        return ovos;
    }

    @Override
    public Double calcularMediaDiaria(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] EggRestController - calcularMediaDiaria");
        Double mediaDiaria = eggService.calcularMediaDiaria(dataInicial, dataFinal);
        log.info("[finaliza] EggRestController - calcularMediaDiaria");
        return mediaDiaria;
    }
}
