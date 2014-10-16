package pl.pragmatists.atm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtmController {

    @RequestMapping(value = "/main")
    public String atm() {
        return "atm";
    }

}
