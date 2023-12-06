package dev.wakandaacademy.chickenapi.egg.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@JsonPropertyOrder({"idEgg", "idChicken", "nomeChicken", "quantidadeOvos", "dataRegistro"})
public class EggListDataResponse {
    private UUID idEgg;
    private UUID idChicken;
    private String nomeChicken;
    private Integer quantidadeOvos;
    private LocalDate dataRegistro;

    public static List<EggListDataResponse> converte(List<Egg> eggs) {
        return eggs.stream()
                .map(EggListDataResponse::new)
                .collect(Collectors.toList());
    }

    public EggListDataResponse(Egg egg) {
        this.idEgg = egg.getIdEgg();
        this.idChicken = egg.getChicken().getIdChicken();
        this.nomeChicken = egg.getChicken().getNome();
        this.quantidadeOvos = egg.getQuantidadeOvos();
        this.dataRegistro = egg.getDataRegistro();
    }
}