package pl.markowski.konrad.app.artgallery.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;
import pl.markowski.konrad.app.artgallery.web.model.ItemModel;

@SpringBootTest
class ItemServiceIntegrationTest {
    @Autowired
    private ItemService itemService;

    @Test
    void read() throws Exception {
        // Given
        Long id = 1L;

        // When
        itemService.create(new ItemModel());
        ItemEntity readItemEntity =  itemService.read(id);

        // Then
        Assertions.assertNotNull(readItemEntity, "readItemEntity is null");
    }
}