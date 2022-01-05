package cz.kryvi.harbata.controller;

import cz.kryvi.harbata.model.dto.HarbataDTO;
import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.service.HarbataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RestController
@RequestMapping(value = "/api/harbata")
public record HarbataController(HarbataService harbataService) {

    @GetMapping("/{id}")
    public Mono<Harbata> getItemById(@PathVariable Long id) {
        return harbataService.getOne(id);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Harbata> getAll() {
        return harbataService.getAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Harbata> save(@RequestBody @Validated HarbataDTO harbata) {
        return harbataService.save(harbataMapper.apply(harbata));
    }

    @PutMapping
    public Mono<Harbata> update(@RequestBody @Validated HarbataDTO harbata) {
        return harbataService.update(harbataMapper.apply(harbata));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteItemById(@PathVariable Long id) {
        return harbataService.delete(id);
    }

    private static final Function<HarbataDTO, Harbata> harbataMapper = harbataDTO ->
            new Harbata(harbataDTO.id(), harbataDTO.name());
}
