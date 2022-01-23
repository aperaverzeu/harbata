package cz.kryvi.harbata.service;

import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.repository.HarbataRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record HarbataService(HarbataRepository harbataRepository) {

    public Mono<Harbata> getOneById(Long id) {
        return harbataRepository.findById(id);
    }

    public Mono<Harbata> getOneByName(String name) {
        return harbataRepository.findHarbataByName(name);
    }

    public Flux<Harbata> getAll() {
        return harbataRepository.findAll();
    }

    public Mono<Harbata> save(Harbata harbata) {
        return harbataRepository.save(harbata);
    }

    public Mono<Harbata> update(Harbata harbata) {
        return harbataRepository
                .existsById(harbata.getId())
                .flatMap(exists -> exists.equals(Boolean.TRUE)
                        ? harbataRepository.save(harbata)
                        : Mono.empty());
    }

    public Mono<Void> delete(Long id) {
        return harbataRepository.deleteById(id);
    }
}
