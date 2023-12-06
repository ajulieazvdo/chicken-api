package dev.wakandaacademy.chickenapi.egg.application.api;

import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Value
@NoArgsConstructor(force = true)
public class EggRequest {
    @NotNull
    private Integer quantidadeOvos;
    @NotNull
    private LocalDate dataRegistro;
}