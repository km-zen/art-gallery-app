package pl.markowski.konrad.app.artgallery.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemControllerTest {

    @Autowired
    private ItemController itemController;

    @Test
    void createView() throws Exception {
        assertThat(itemController).isNotNull();
    }
}