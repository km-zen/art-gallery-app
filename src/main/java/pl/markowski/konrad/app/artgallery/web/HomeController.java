package pl.markowski.konrad.app.artgallery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/artgallery")
public class HomeController {
    public static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());

    // create view
    @GetMapping
    public String createView(){
        LOGGER.info("createView()");
        return "home";
    }
}
