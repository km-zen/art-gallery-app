package pl.markowski.konrad.app.artgallery.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.markowski.konrad.app.artgallery.repository.entity.AuthorEntity;
import pl.markowski.konrad.app.artgallery.service.AuthorService;
import pl.markowski.konrad.app.artgallery.web.model.AuthorModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {
    private static final Logger LOGGER = Logger.getLogger(AuthorController.class.getName());

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // L - list
    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", authorService.list());
        return  "list-authors";
    }
    @GetMapping(value = "/create")
    public String createView(){
        LOGGER.info("createView()");
        return "create-author";
    }

    // C - create
    @PostMapping(value = "/create")
    public String create(AuthorModel authorModel) {
        LOGGER.info("create(" + authorModel + ")");
        authorService.create(authorModel);
        return "redirect:/authors";
    }

    // R - read
    @GetMapping("/read/{id}")
    public String read(@PathVariable (name = "id") Long id, Model model) throws Exception {
        LOGGER.info("read(" + id + ")");
        AuthorEntity author = authorService.read(id);
        model.addAttribute("author", author);
        return "read-author";
    }
    // U - update
    @GetMapping("/update/{id}")
    public String updateView(@PathVariable(name = "id") Long id, Model model) throws Exception {
        LOGGER.info("updateView(" + id + ")");
        AuthorEntity author = authorService.read(id);
        model.addAttribute("author",author);
        return "update-author";
    }
    @PostMapping("/update")
    public String update(AuthorModel authorModel) throws Exception {
        LOGGER.info("update(" + authorModel + ")");
        authorService.update(authorModel);
        return "redirect:/authors";
    }
    // D - delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws Exception {
        LOGGER.info("delete(" + id + ")");
        authorService.delete(id);
        return "list-authors";
    }

}
