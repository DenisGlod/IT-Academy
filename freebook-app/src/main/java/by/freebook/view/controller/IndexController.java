package by.freebook.view.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping(path = {"/", "/index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
