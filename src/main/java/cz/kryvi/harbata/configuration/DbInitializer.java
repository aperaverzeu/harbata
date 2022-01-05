package cz.kryvi.harbata.configuration;

import cz.kryvi.harbata.model.entity.Harbata;
import cz.kryvi.harbata.repository.HarbataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.List;

@EnableReactiveMongoRepositories(basePackageClasses = HarbataRepository.class)
@Configuration
@Slf4j
public class DbInitializer {
    @Bean
    CommandLineRunner commandLineRunner(HarbataRepository harbataRepository) {
        return args -> harbataRepository.saveAll(List.of(
                new Harbata(1L, "Čaja pieršaja"),
                new Harbata(2L, "Čaja druhaja")))
                .subscribe();
    }
}
