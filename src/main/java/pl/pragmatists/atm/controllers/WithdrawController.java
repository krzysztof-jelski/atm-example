package pl.pragmatists.atm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class WithdrawController {

    @RequestMapping(value = "/withdraw", method = POST)
    public String withdraw() {
        return "redirect:main";
    }

}
