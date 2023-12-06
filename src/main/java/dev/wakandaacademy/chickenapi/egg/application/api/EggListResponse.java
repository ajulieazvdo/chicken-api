package dev.wakandaacademy.chickenapi.egg.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@JsonPropertyOrder({"idEgg", "idChicken", "nomeChicken", "quantidadeOvos", "dataRegistro"})
public class EggListResponse {
    private UUID idEgg;
    private UUID idChicken;
    private String nomeChicken;
    private Integer quantidadeOvos;
    private LocalDate dataRegistro;

    public static List<EggListResponse> converte(List<Egg> eggs) {
        return eggs.stream()
                .filter(egg -> egg.getChicken() != null)
                .map(EggListResponse::new)
                .collect(Collectors.toList());
    }

    public EggListResponse(Egg egg) {
        this.idEgg = egg.getIdEgg();
        this.idChicken = egg.getChicken().getIdChicken();
        this.nomeChicken = egg.getChicken().getNome();
        this.quantidadeOvos = egg.getQuantidadeOvos();
        this.dataRegistro = egg.getDataRegistro();
    }
}