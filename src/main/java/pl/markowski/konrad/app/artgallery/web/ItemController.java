package pl.markowski.konrad.app.artgallery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.markowski.konrad.app.artgallery.service.ItemService;
import pl.markowski.konrad.app.artgallery.web.model.ItemModel;

import java.util.logging.Logger;

@Controller
@RequestMapping
public class ItemController {
    private static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

    //@Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String createView() {
        LOGGER.info("creteView()");
        return "create-item";
    }

    // C - create
    @PostMapping
//    public String create(String title, String description) {
    public String create(ItemModel itemModel) {
        LOGGER.info("create(" + itemModel + ")");
        itemService.create(itemModel);
//        LOGGER.info("create(" + description + ")");
        return "create-item";
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
