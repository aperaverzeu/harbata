package cz.kryvi.harbata.repository;

import cz.kryvi.harbata.model.entity.Harbata;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarbataRepository extends ReactiveMongoRepository<Harbata, Long> { }
