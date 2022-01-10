package cz.kryvi.harbata.service;

import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.repository.HarbataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public record HarbataService(HarbataRepository harbataRepository) {

    public Mono<Harbata> getOne(Long id) {
        return harbataRepository
                .findById(id)
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we don't have this harbata element");
                    throw new IllegalStateException(throwable);
                });
    }

    public Mono<Harbata> getOneByName(String name) {
        return harbataRepository
                .findHarbataByName(name)
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we don't have this harbata element");
                    throw new IllegalStateException(throwable);
                });
    }

    public Flux<Harbata> getAll() {
        return harbataRepository
                .findAll()
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we don't have these harbata elements");
                    throw new IllegalStateException(throwable);
                });
    }

    public Mono<Harbata> save(Harbata harbata) {
        return harbataRepository
                .save(harbata)
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we cannot save this harbata element");
                    throw new IllegalStateException(throwable);
                });
    }

    public Mono<Harbata> update(Harbata harbata) {
        return harbataRepository
                .findById(harbata.getId())
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we cannot update this harbata element");
                    throw new IllegalStateException(throwable);
                })
                .flatMap(harbataRepository::save);
    }

    public Mono<Void> delete(Long id) {
        return harbataRepository
                .deleteById(id)
                .doOnError(throwable -> {
                    log.error("Oops! Error here. It seems we cannot delete this harbata element");
                    throw new IllegalStateException(throwable);
                });
    }
}
