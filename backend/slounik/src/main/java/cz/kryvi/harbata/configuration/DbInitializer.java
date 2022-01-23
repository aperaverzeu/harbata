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
                        new Harbata(1L, "Гарбата", "Harbata", """
                                Вечна зялёная расьліна зь віду камэлія, якая паходзіць з паўднёва-ўсходняй Азіі,
                                а таксама духмяны напой, які звычайна атрымліваюць шляхам заліваньня гарачай вадой або
                                кіпенем высушанага лісьця гэтай расьліны. Пасьля вады, гарбата зьяўляецца найбольш
                                шырокаспажываным напоем у сьвеце. Яна мае зьлёгку горкі і вязкі водар"""),
                        new Harbata(2L, "Імбрык", "Imbryk", """
                                Невялічкая кухонная прылада для запарваньня гарбаты ці іншых напояў у гарачай вадзе.
                                Звычайна імбрычкі маюць зьверху адтуліну з накрыўкай, празь якую засыпаецца гарбата і
                                заліваецца вада; ручку дзеля трыманьня рукой; і рыльца, адкуль наліваюць запараную
                                гарбату. У некаторых выпадках унутры імбрычка можа зьмяшчацца сітца, каб працэжваць
                                лісьце гарбаты пры наліваньні"""))
                )
                .subscribe();
    }
}
