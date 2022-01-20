package cz.kryvi.harbata.controller;

import cz.kryvi.harbata.model.dto.HarbataDTO;
import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.model.mapper.HarbataMapper;
import cz.kryvi.harbata.service.HarbataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/harbata")
public record HarbataController(HarbataService harbataService,
                                HarbataMapper harbataMapper) {

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Harbata>> getItemById(@PathVariable Long id) {
        return harbataService.getOneById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Flux<ResponseEntity<Harbata>> getAll() {
        return harbataService.getAll()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Harbata>> save(@RequestBody @Validated HarbataDTO harbata) {
        return harbataService.save(harbataMapper.apply(harbata))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PutMapping
    public Mono<ResponseEntity<Harbata>> update(@RequestBody @Validated HarbataDTO harbata) {
        return harbataService.update(harbataMapper.apply(harbata))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteItemById(@PathVariable Long id) {
        return harbataService.delete(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
