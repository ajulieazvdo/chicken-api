package dev.wakandaacademy.chickenapi.chicken.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@JsonPropertyOrder({"idChicken","nome", "dataNascimento"})
public class ChickenListResponse {
    private UUID idChicken;
    private String nome;
    private LocalDate dataNascimento;

    public static List<ChickenListResponse> converte(List<Chicken> galinhas) {
        return galinhas.stream()
                .map(ChickenListResponse::new)
                . collect(Collectors.toList());
    }

    public ChickenListResponse(Chicken chicken) {
        this.idChicken = chicken.getIdChicken();
        this.nome = chicken.getNome();
        this.dataNascimento = chicken.getDataNascimento();
    }
}
