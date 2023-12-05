package gabriel.ademar.diaz.arnold.psychobook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class ViewController {

    @GetMapping
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String index_admin() {
        return "index_admin";
    }
}
