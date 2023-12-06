package dev.wakandaacademy.chickenapi.egg.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/egg")
@Tag(name = "Egg", description = "Records of eggs")
public interface EggAPI {
    @PostMapping(path = "/{idChicken}")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create a egg", description = "Create one egg by chicken")
    EggResponse criarOvo(@PathVariable UUID idChicken, @RequestBody @Valid EggRequest eggRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find all egg", description = "Find all eggs")
    List<EggListResponse> buscarOvos();

    @GetMapping(path = "/{idEgg}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find One Egg", description = "Find one egg")
    EggDetalhadoResponse buscarOvoDaGalinhaComId(@PathVariable UUID idEgg);

    @DeleteMapping(path = "/{idEgg}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete One Egg", description = "Delete one egg")
    void deletarOvoDaGalinhaComId(@PathVariable UUID idEgg);

    @PatchMapping(path = "/{idChicken}/{idEgg}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Patch One Egg", description = "Patch one egg by chicken id")
    void alterarOvoDaGalinha(@PathVariable UUID idChicken, @PathVariable UUID idEgg, @RequestBody @Valid EggAlteraRequest eggRequest);

    @GetMapping("/{idChicken}/data")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find Eggs Chicken by Date", description = "Find Eggs Chicken of Date by chicken id")
    List<EggListDataResponse> buscarOvosDaGalinhaEmDataEspecifica(@PathVariable UUID idChicken,
                          @RequestParam("dataRegistro") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRegistro);

    @GetMapping(path = "/media-diaria-ovos")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Calculate average of eggs", description = "Calculate the average number of eggs of all chickens in a specific data")
    Double calcularMediaDiaria(@RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
                               @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal);
}