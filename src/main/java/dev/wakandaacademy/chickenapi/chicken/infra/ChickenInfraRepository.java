package dev.wakandaacademy.chickenapi.chicken.infra;

import dev.wakandaacademy.chickenapi.chicken.application.repository.ChickenRepository;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ChickenInfraRepository implements ChickenRepository {
    private final ChickenSpringJpaRepository chickenSpringJpaRepository;
    @Override
    public Chicken criarGalinha(Chicken chicken) {
        log.info("[inicia] ChickenInfraRepository - criarGalinha");
        Chicken chickenCriado = chickenSpringJpaRepository.save(chicken);
        log.info("[finaliza] ChickenInfraRepository - criarGalinha");
        return chickenCriado;
    }

    @Override
    public List<Chicken> listarTodasGalinhas() {
        log.info("[inicia] ChickenInfraRepository - listarTodasGalinhas");
        List<Chicken> listarGalinhas = chickenSpringJpaRepository.findAll();
        log.info("[finaliza] ChickenInfraRepository - listarTodasGalinhas");
        return listarGalinhas;
    }

    @Override
    public Chicken listarUmaGalinhaPorId(UUID idChicken) {
        log.info("[inicia] ChickenInfraRepository - listarUmaGalinhaPorId");
        Chicken galinha = chickenSpringJpaRepository.findById(idChicken)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Galinha não encontrada!"));
        log.info("[finaliza] ChickenInfraRepository - listarUmaGalinhaPorId");
        return galinha;
    }

    @Override
    public void deletarUmaGalinha(Chicken chicken) {
        log.info("[inicia] ChickenInfraRepository - deletarUmaGalinha");
        chickenSpringJpaRepository.delete(chicken);
        log.info("[finaliza] ChickenInfraRepository - deletarUmaGalinha");
    }
}