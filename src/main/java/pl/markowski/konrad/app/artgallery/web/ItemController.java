package pl.markowski.konrad.app.artgallery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.markowski.konrad.app.artgallery.repository.entity.ItemEntity;
import pl.markowski.konrad.app.artgallery.service.ItemService;
import pl.markowski.konrad.app.artgallery.web.model.ItemModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/items")
public class ItemController {
    // TODO: 24.08.2022  napisać test jednostkowy dla kontrolera dla metody createView() zgodnie z https://spring.io/guides/gs/testing-web/
    private static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

    //@Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // L - list
    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", itemService.list());
        return "list-items";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("creteView()");
        return "create-item";
    }

    // C - create
    @PostMapping(value = "/create")
//    public String create(String title, String description) {
    public String create(ItemModel itemModel) {
        LOGGER.info("create(" + itemModel + ")");
        itemService.create(itemModel);
//        LOGGER.info("create(" + description + ")");
//        return "list-items";
        return "redirect:/items";
    }

    // R - read
    @GetMapping("/read/{id}")
    public String read(@PathVariable(name = "id") Long id, Model model) throws Exception {
        LOGGER.info("read(" + id + ")");
        ItemEntity item = itemService.read(id);
        model.addAttribute("item", item);
        return "read-item";
    }

    // U - update
    @GetMapping("/update/{id}")
    public String updateView(
            @PathVariable(name = "id") Long id, Model model) throws Exception {
        LOGGER.info("updateView(" + id + ")");
        ItemEntity item = itemService.read(id);
        model.addAttribute("item", item);
        return "update-item";
    }

//    @PostMapping("/update/{id}")
    @PostMapping("/update")
    public String update(
//            @PathVariable(name = "id") Long id,
            ItemModel itemModel, Model model) throws Exception {
        LOGGER.info("update(" + itemModel + ")");
        itemService.update( itemModel);

//        return "list-items";
        return "redirect:/items";
    }

    // D - delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws Exception {
        LOGGER.info("delete(" + id + ")");
        itemService.delete(id);
        return "redirect:/items";
    }


}
