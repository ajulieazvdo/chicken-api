package dev.wakandaacademy.chickenapi.egg.infra;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.application.repository.EggRepository;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import dev.wakandaacademy.chickenapi.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EggInfraRepository implements EggRepository {
    private final EggSpringDataJpaRepository eggSpringDataJpaRepository;

    @Override
    public Egg criarEggs(Egg egg) {
        log.info("[inicia] EggInfraRepository - criarEgg");
        Egg eggCriado = eggSpringDataJpaRepository.save(egg);
        log.info("[finaliza] EggInfraRepository - criarEgg");
        return eggCriado;
    }

    @Override
    public List<Egg> buscarOvos() {
        log.info("[inicia] EggInfraRepository - criarEgg");
        List<Egg> eggs = eggSpringDataJpaRepository.findAll();
        log.info("[finaliza] EggInfraRepository - criarEgg");
        return eggs;
    }

    @Override
    public Egg buscarOvoDaGalinhaPorId(UUID idEgg) {
        log.info("[inicia] EggInfraRepository - buscarOvoDaGalinhaPorId");
        Egg egg = eggSpringDataJpaRepository.findById(idEgg)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Codigo do ovo não existe"));
        log.info("[finaliza] EggInfraRepository - buscarOvoDaGalinhaPorId");
        return egg;
    }

    @Override
    public void deletaOvo(Egg egg) {
        log.info("[inicia] EggInfraRepository - deletaOvo");
        eggSpringDataJpaRepository.delete(egg);
        log.info("[finaliza] EggInfraRepository - deletaOvo");
    }

    @Override
    public List<Egg> buscarOvosDaGalinhaEmDataEspecifica(Chicken chicken, LocalDate dataRegistro) {
        log.info("[inicia] EggInfraRepository - buscaOvosDaGalinhaEmDataEspecifica");
        List<Egg> eggs = eggSpringDataJpaRepository.findQuantidadeOvosByChickenAndDataRegistro(chicken, dataRegistro);
        log.info("[finaliza] EggInfraRepository - buscaOvosDaGalinhaEmDataEspecifica");
        return eggs;
    }

    @Override
    public List<Egg> buscarTodosOvosPorData(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] EggsRecordsInfraRepository - buscaOvosDaGalinhaEmDataEspecifica");
        List<Egg> eggs = eggSpringDataJpaRepository.findAllByDataRegistroBetween(dataFinal, dataFinal);
        log.info("[finaliza] EggsRecordsInfraRepository - buscaOvosDaGalinhaEmDataEspecifica");
        return eggs;
    }
}