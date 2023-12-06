package dev.wakandaacademy.chickenapi.egg.application.service;

import dev.wakandaacademy.chickenapi.chicken.application.repository.ChickenRepository;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.application.api.*;
import dev.wakandaacademy.chickenapi.egg.application.repository.EggRepository;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import dev.wakandaacademy.chickenapi.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EggApplicationService implements EggService {
    private final ChickenRepository chickenRepository;
    private final EggRepository eggsRepository;

    @Override
    public EggResponse criarEggs(UUID idChicken, EggRequest eggRequest) {
        log.info("[inicia] EggApplicationService - criarEggs");
        chickenRepository.listarUmaGalinhaPorId(idChicken);
        Egg egg = eggsRepository.criarEggs(new Egg(idChicken, eggRequest));
        log.info("[finaliza] EggApplicationService - criarEggs");
        return EggResponse.builder()
                .idEgg(egg.getIdEgg())
                .build();
    }

    @Override
    public List<EggListResponse> buscarOvos() {
        log.info("[inicia] EggApplicationService - buscarOvos");
        List<Egg> eggs = eggsRepository.buscarOvos();
        log.info("[finaliza] EggApplicationService - buscarOvos");
        return EggListResponse.converte(eggs);
    }

    @Override
    public EggDetalhadoResponse buscarOvoDaGalinhaPorId(UUID idEgg) {
        log.info("[inicia] EggApplicationService - buscarOvoDaGalinhaPorId");
        Egg egg = eggsRepository.buscarOvoDaGalinhaPorId(idEgg);
        log.info("[finaliza] EggApplicationService - buscarOvoDaGalinhaPorId");
        return new EggDetalhadoResponse(egg);
    }

    @Override
    public void deletarOvoDaGalinhaComId(UUID idEgg) {
        log.info("[inicia] EggApplicationService - deletarOvoDaGalinhaComId");
        Egg egg = eggsRepository.buscarOvoDaGalinhaPorId(idEgg);
        eggsRepository.deletaOvo(egg);
        log.info("[finaliza] EggApplicationService - deletarOvoDaGalinhaComId");
    }

    @Override
    public void alterarOvoDaGalinha(UUID idChicken, UUID idEgg, EggAlteraRequest eggRequest) {
        log.info("[inicia] EggApplicationService - deletarOvoDaGalinhaComId");
        chickenRepository.listarUmaGalinhaPorId(idChicken);
        Egg egg = eggsRepository.buscarOvoDaGalinhaPorId(idEgg);
        egg.altera(eggRequest);
        eggsRepository.criarEggs(egg);
        log.info("[finaliza] EggApplicationService - deletarOvoDaGalinhaComId");
    }

    @Override
    public List<EggListDataResponse> buscarOvosDaGalinhaEmDataEspecifica(UUID idChicken, LocalDate dataRegistro) {
        log.info("[inicia] EggApplicationService - buscarOvosDaGalinhaEmDataEspecifica");
        Chicken chicken = chickenRepository.listarUmaGalinhaPorId(idChicken);
        List<Egg> eggs = eggsRepository.buscarOvosDaGalinhaEmDataEspecifica(chicken, dataRegistro);
        log.info("[finaliza] EggApplicationService - buscarOvosDaGalinhaEmDataEspecifica");
        return EggListDataResponse.converte(eggs);
    }

    @Override
    public Double calcularMediaDiaria(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] EggApplicationService - calcularMediaDiaria");
        List<Egg> eggs = eggsRepository.buscarTodosOvosPorData(dataInicial, dataFinal);
        Double calculo = calcularMedia(eggs, dataInicial, dataFinal);
        log.info("[final] EggApplicationService - calcularMediaDiaria");
        return calculo;
    }

    private Double calcularMedia(List<Egg> eggs, LocalDate dataInicial, LocalDate dataFinal) {
        int totalOvos = 0;
        long dia = 0;
        for (Egg egg: eggs) {
            if (dataInicial.equals(dataFinal)){
                totalOvos += egg.getQuantidadeOvos();
                dia++;
            } else{
                throw APIException.build(HttpStatus.BAD_REQUEST, "Data inicial tem que ser igual Data final");
            }
        }
        return dia != 0 ? (double) totalOvos / dia : 0;
    }
}