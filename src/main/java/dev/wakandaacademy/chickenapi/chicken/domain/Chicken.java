package dev.wakandaacademy.chickenapi.chicken.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.wakandaacademy.chickenapi.chicken.application.api.ChickenAlteraRequest;
import dev.wakandaacademy.chickenapi.chicken.application.api.ChickenRequest;
import dev.wakandaacademy.chickenapi.egg.domain.Egg;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "idChicken")
public class Chicken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",name = "id_chicken", updatable = false, unique = true, nullable = false)
    private UUID idChicken;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDate dataNascimento;

    public Chicken(ChickenRequest chickenRequest) {
        this.nome = chickenRequest.getNome();
        this.dataNascimento = chickenRequest.getDataNascimento();
    }
    public void altera(ChickenAlteraRequest chickenRequest) {
        this.nome = chickenRequest.getNome();
        this.dataNascimento = chickenRequest.getDataNascimento();
    }

    @OneToMany(mappedBy = "chicken")
    private List<Egg> eggs = new ArrayList<>();
}