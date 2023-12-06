package dev.wakandaacademy.chickenapi.chicken.application.api;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
@Value
@NoArgsConstructor(force = true)
public class ChickenAlteraRequest {
    private String nome;
    private LocalDate dataNascimento;
}