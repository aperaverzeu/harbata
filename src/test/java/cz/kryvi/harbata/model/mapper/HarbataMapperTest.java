package cz.kryvi.harbata.model.mapper;

import cz.kryvi.harbata.model.dto.HarbataDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = HarbataMapper.class)
class HarbataMapperTest {

    @Autowired
    private HarbataMapper harbataMapper;

    @Test
    @DisplayName("Now Entity!")
    void shouldTurnDTOIntoEntity() {
        var harbataDTO = new HarbataDTO(42L, "Bychaviec");

        var harbata = harbataMapper.apply(harbataDTO);

        assertEquals(42L, harbata.getId());
        assertEquals("Bychaviec", harbata.getName());
    }
}