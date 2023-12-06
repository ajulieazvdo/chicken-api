package dev.wakandaacademy.chickenapi.chicken.application.api;

import lombok.*;

import java.util.UUID;

@Value
@Builder
public class ChickenResponse {
    private UUID idChicken;

}