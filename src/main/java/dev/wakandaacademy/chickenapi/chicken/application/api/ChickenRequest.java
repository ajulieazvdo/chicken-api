package dev.wakandaacademy.chickenapi.chicken.application.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@NoArgsConstructor(force = true)
public class ChickenRequest {
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
}