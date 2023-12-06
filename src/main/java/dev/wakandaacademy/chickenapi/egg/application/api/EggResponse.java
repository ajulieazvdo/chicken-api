package dev.wakandaacademy.chickenapi.egg.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class EggResponse {
    private UUID idEgg;
}