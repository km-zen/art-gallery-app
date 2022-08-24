package pl.markowski.konrad.app.artgallery.service;

import org.springframework.stereotype.Service;
import pl.markowski.konrad.app.artgallery.repository.ItemRepository;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;
import pl.markowski.konrad.app.artgallery.web.model.ItemModel;

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
        itemEntity.setTitle("Krajobraz");
        itemEntity.setDescription("Ładny krajobraz");
        itemRepository.save(itemEntity);
    }

    // R - read
    public void read() {
    }

    // U - update
    public void update() {
    }

    // D - delete
    public void delete() {
    }

    // L - list
    public void list() {
    }
}
