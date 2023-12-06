package dev.wakandaacademy.chickenapi.egg.domain;

import dev.wakandaacademy.chickenapi.chicken.domain.Chicken;
import dev.wakandaacademy.chickenapi.egg.application.api.EggAlteraRequest;
import dev.wakandaacademy.chickenapi.egg.application.api.EggRequest;
import dev.wakandaacademy.chickenapi.handler.APIException;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "idEgg")
public class Egg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",name = "id_egg", updatable = false, unique = true, nullable = false)
    private UUID idEgg;
    @Column(nullable = false)
    private Integer quantidadeOvos;
    @Column(nullable = false)
    private LocalDate dataRegistro;

    @ManyToOne
    @JoinColumn(name = "chicken_id", nullable = false)
    private Chicken chicken;
    public Egg(UUID idChicken, EggRequest eggRequest) {
        this.quantidadeOvos = eggRequest.getQuantidadeOvos();
        this.dataRegistro = eggRequest.getDataRegistro();
        getIdChicken(idChicken);

    }
    private void getIdChicken(UUID idChicken){
        if (idChicken != null){
            this.chicken = new Chicken();
            this.chicken.setIdChicken(idChicken);
        }
    }
    public void altera(EggAlteraRequest eggRequest) {
        this.quantidadeOvos = eggRequest.getQuantidadeOvos();
        this.dataRegistro = eggRequest.getDataRegistro();
    }
}