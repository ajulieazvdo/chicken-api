package dev.wakandaacademy.chickenapi.chicken.application.api;

import dev.wakandaacademy.chickenapi.chicken.application.service.ChickenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ChickenRestController implements ChickenAPI {
    private final ChickenService chickenService;

    @Override
    public ChickenResponse criarGalinha(ChickenRequest chickenRequest) {
        log.info("[inicia] ChickenRestController - criarGalinha");
        ChickenResponse galinhaCriada = chickenService.criarGalinha(chickenRequest);
        log.info("[finaliza] ChickenRestController - criarGalinha");
        return galinhaCriada;
    }

    @Override
    public List<ChickenListResponse> listarTodasGalinhas() {
        log.info("[inicia] ChickenRestController - listarTodasGalinhas");
        List<ChickenListResponse> galinhas = chickenService.listarTodasGalinhas();
        log.info("[finaliza] ChickenRestController - listarTodasGalinhas");
        return galinhas;
    }

    @Override
    public ChickenDetalhadoResponse listarUmaGalinhaPorId(UUID idChicken) {
        log.info("[inicia] ChickenRestController - listarUmaGalinhaPorId");
        ChickenDetalhadoResponse galinha = chickenService.listarUmaGalinhaPorId(idChicken);
        log.info("[finaliza] ChickenRestController - listarUmaGalinhaPorId");
        return galinha;
    }

    @Override
    public void deletarUmaGalinhaPorId(UUID idChicken) {
        log.info("[inicia] ChickenRestController - deletarUmaGalinhaPorId");
        chickenService.deletarUmaGalinhaPorId(idChicken);
        log.info("[finaliza] ChickenRestController - deletarUmaGalinhaPorId");
    }

    @Override
    public void alterarUmaGalinha(UUID idChicken, ChickenAlteraRequest chickenRequest) {
        log.info("[inicia] ChickenRestController - alterarUmaGalinha");
        chickenService.alterarUmaGalinha(idChicken, chickenRequest);
        log.info("[finaliza] ChickenRestController - alterarUmaGalinha");
    }
}
