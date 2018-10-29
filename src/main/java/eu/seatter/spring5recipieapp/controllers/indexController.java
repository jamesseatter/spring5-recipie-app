package eu.seatter.spring5recipieapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jas on 11/10/2018
 */
@Controller
public class indexController {

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {
        return "index";
    }
}
