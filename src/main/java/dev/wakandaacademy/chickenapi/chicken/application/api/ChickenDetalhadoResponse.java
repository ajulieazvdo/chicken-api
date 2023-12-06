package dev.wakandaacademy.chickenapi.chicken.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@JsonPropertyOrder({"idChicken","nome", "dataNascimento"})
public class ChickenDetalhadoResponse {
    private UUID idChicken;
    private String nome;
    private LocalDate dataNascimento;
    public ChickenDetalhadoResponse(Chicken galinha) {
        this.idChicken = galinha.getIdChicken();
        this.nome = galinha.getNome();
        this.dataNascimento = galinha.getDataNascimento();
    }
}
