package dev.wakandaacademy.chickenapi.egg.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@JsonPropertyOrder({"idEgg", "nomeChicken", "quantidadeOvos", "dataRegistro"})
public class EggDetalhadoResponse {
    private UUID idEgg;
    private Integer quantidadeOvos;
    private String nomeChicken;
    private LocalDate dataRegistro;

    public EggDetalhadoResponse(Egg egg) {
        this.idEgg = egg.getIdEgg();
        this.nomeChicken = egg.getChicken().getNome();
        this.quantidadeOvos = egg.getQuantidadeOvos();
        this.dataRegistro = egg.getDataRegistro();
    }
}