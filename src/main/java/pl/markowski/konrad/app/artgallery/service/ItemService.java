package pl.markowski.konrad.app.artgallery.service;

import org.springframework.stereotype.Service;
import pl.markowski.konrad.app.artgallery.repository.ItemRepository;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;
import pl.markowski.konrad.app.artgallery.web.model.ItemModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ItemService {
    private static final Logger LOGGER = Logger.getLogger(ItemService.class.getName());

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //C - create
    public void create(ItemModel itemModel) {
        LOGGER.info("create(" + itemModel + ")");
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setTitle(itemModel.getTitle());
        itemEntity.setDescription(itemModel.getDescription());
        itemRepository.save(itemEntity);
    }

    // R - read
    public ItemEntity read(Long id) throws Exception {
        LOGGER.info("read(" + id + ")");
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(id);
        ItemEntity itemEntity = optionalItemEntity.orElseThrow(
                () -> new Exception("nie znaleziono przedmiotu o id: " + id));
        LOGGER.info("read(...) =  " + itemEntity);
        return itemEntity;
    }

    // U - update
    public void update( ItemModel itemModel) throws Exception {
        LOGGER.info("update(" + itemModel + ")");
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(itemModel.getId());
        ItemEntity itemEntity = optionalItemEntity.orElseThrow(
                () -> new Exception("nie znaleziono przedmiotu o id: " + itemModel.getId()));
        itemEntity.setTitle(itemModel.getTitle());
        itemEntity.setDescription(itemModel.getDescription());
        itemRepository.save(itemEntity);
    }

    // D - delete
    public void delete(Long id) throws Exception {
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(id);
        ItemEntity itemEntity = optionalItemEntity.orElseThrow(
                () -> new Exception("nie znaleziono przedmiotu o id: " + id));
        itemRepository.delete(itemEntity);
    }

    // L - list
    public List<ItemEntity> list() {
        return itemRepository.findAll();
    }
}
