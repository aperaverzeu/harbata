package cz.kryvi.harbata;

import cz.kryvi.harbata.controller.HarbataController;
import cz.kryvi.harbata.service.HarbataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class HarbataApplicationTests {

    @Autowired
    private HarbataController harbataController;

    @Autowired
    private HarbataService harbataService;

    @Test
    void contextLoads() {
        assertNotNull(harbataController);
        assertNotNull(harbataService);
    }

}
