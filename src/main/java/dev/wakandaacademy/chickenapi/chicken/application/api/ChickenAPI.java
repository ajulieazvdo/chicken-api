package dev.wakandaacademy.chickenapi.chicken.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/galinha")
@Tag(name = "Chicken", description = "Records of chickens")
public interface ChickenAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Create a chicken", description = "Create one chicken")
    ChickenResponse criarGalinha(@RequestBody @Valid ChickenRequest chickenRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find all chickens", description = "Find all chickens")
    List<ChickenListResponse> listarTodasGalinhas();

    @GetMapping("/{idChicken}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Find One Chicken", description = "Find one chicken")
    ChickenDetalhadoResponse listarUmaGalinhaPorId(@PathVariable UUID idChicken);

    @DeleteMapping("/{idChicken}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete One Chicken", description = "Delete one chicken by chicken id")
    void deletarUmaGalinhaPorId(@PathVariable UUID idChicken);

    @PatchMapping("/{idChicken}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Patch One Chicken", description = "Patch one chicken")
    void alterarUmaGalinha(@PathVariable UUID idChicken, @RequestBody @Valid ChickenAlteraRequest chickenRequest);
}