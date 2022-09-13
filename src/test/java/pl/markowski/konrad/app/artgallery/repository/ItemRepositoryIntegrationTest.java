package pl.markowski.konrad.app.artgallery.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;

import java.util.Optional;

@SpringBootTest
class ItemRepositoryIntegrationTest {
    public static final String ITEM_TITLE_KRAJOBRAZ = "Krajobraz";

    @Autowired
    private ItemRepository itemRepository;

//    public ItemRepositoryIntegrationTest(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @Test
    void create() {
        // Given
        ItemEntity itemEntity = new ItemEntity();
        // When
        ItemEntity savedItemEntity = itemRepository.save(itemEntity);
        // Then
        Assertions.assertNotNull(savedItemEntity, "savedItemEntity is null");
    }

    @Test
    void create1() {
        // Given
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setTitle(ITEM_TITLE_KRAJOBRAZ);
        // When
        ItemEntity savedItemEntity = itemRepository.save(itemEntity);
        // Then
        Assertions.assertEquals(itemEntity.getTitle(), savedItemEntity.getTitle(), "Title is not equal");
    }

    @Test
    void read() throws Exception {
        // Given
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setTitle(ITEM_TITLE_KRAJOBRAZ);
        // When
        ItemEntity savedItemEntity = itemRepository.save(itemEntity);

        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(savedItemEntity.getId());
//        if (optionalItemEntity.isPresent()) {
//            ItemEntity opItemEntity = optionalItemEntity.get();
//            if (opItemEntity != null) {
//               return opItemEntity //zwrócimy nienullowy obiekt
//            } else {
//                new ItemEntity(); // zwrócimy nowy obiekt
//            }
//        }

//        optionalItemEntity.orElse(new ItemEntity());
//        optionalItemEntity.orElseThrow();
        ItemEntity readItemEntity = optionalItemEntity.orElseThrow(() -> new Exception("nie znaleziono przedmiotu o id: " + savedItemEntity.getId()));

        // Then
        Assertions.assertEquals(ITEM_TITLE_KRAJOBRAZ, readItemEntity.getTitle());

    }
}