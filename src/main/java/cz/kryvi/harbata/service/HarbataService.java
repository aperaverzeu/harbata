package cz.kryvi.harbata.service;

import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.repository.HarbataRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record HarbataService(HarbataRepository harbataRepository) {

    public Mono<Harbata> getOne(Long id) {
        return harbataRepository.findById(id);
    }

    public Flux<Harbata> getAll() {
        return harbataRepository.findAll();
    }

    public Mono<Harbata> save(Harbata harbata) {
        return harbataRepository.save(harbata);
    }

    public Mono<Harbata> update(Harbata harbata) {
        return harbataRepository
                .findById(harbata.getId())
                .flatMap(harbataRepository::save)
                .doOnError(throwable -> {
                    throw new IllegalStateException();
                });
    }

    public Mono<Void> delete(Long id) {
        return harbataRepository.deleteById(id);
    }
}
