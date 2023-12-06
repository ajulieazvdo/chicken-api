package dev.wakandaacademy.chickenapi.chicken.application.service;

import dev.wakandaacademy.chickenapi.chicken.application.api.*;
import dev.wakandaacademy.chickenapi.chicken.application.repository.ChickenRepository;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ChickenApplicationService implements ChickenService {
    private final ChickenRepository chickenRepository;

    @Override
    public ChickenResponse criarGalinha(ChickenRequest chickenRequest) {
        log.info("[inicia] ChickenApplicationService - criarGalinha");
        Chicken galinha = chickenRepository.criarGalinha(new Chicken(chickenRequest));
        log.info("[finaliza] ChickenApplicationService - criarGalinha");
        return ChickenResponse.builder()
                .idChicken(galinha.getIdChicken())
                .build();
    }

    @Override
    public List<ChickenListResponse> listarTodasGalinhas() {
        log.info("[inicia] ChickenApplicationService - listarTodasGalinhas");
        List<Chicken> galinhas = chickenRepository.listarTodasGalinhas();
        log.info("[finaliza] ChickenApplicationService - listarTodasGalinhas");
        return ChickenListResponse.converte(galinhas);
    }

    @Override
    public ChickenDetalhadoResponse listarUmaGalinhaPorId(UUID idChicken) {
        log.info("[inicia] ChickenApplicationService - listarUmaGalinhaPorId");
        Chicken galinha  = chickenRepository.listarUmaGalinhaPorId(idChicken);
        log.info("[finaliza] ChickenApplicationService - listarUmaGalinhaPorId");
        return new ChickenDetalhadoResponse(galinha);
    }

    @Override
    public void deletarUmaGalinhaPorId(UUID idChicken) {
        log.info("[inicia] ChickenApplicationService - deletarUmaGalinhaPorId");
        Chicken chicken = chickenRepository.listarUmaGalinhaPorId(idChicken);
        chickenRepository.deletarUmaGalinha(chicken);
        log.info("[finaliza] ChickenApplicationService - deletarUmaGalinhaPorId");
    }

    @Override
    public void alterarUmaGalinha(UUID idChicken, ChickenAlteraRequest chickenRequest) {
        log.info("[inicia] ChickenApplicationService - alterarUmaGalinha");
        Chicken chicken = chickenRepository.listarUmaGalinhaPorId(idChicken);
        chicken.altera(chickenRequest);
        chickenRepository.criarGalinha(chicken);
        log.info("[finaliza] ChickenApplicationService - alterarUmaGalinha");
    }
}