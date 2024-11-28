package org.dev.sbprac2.rest;


import org.dev.sbprac2.services.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    Teacher Saswade;

    @Autowired
    public void getStatus(@Qualifier("thakurSir") Teacher Saswade) {
        this.Saswade = Saswade;
    }

    @Value("${my.name}")
    private String name;

    @GetMapping("/")
    public String index() {
        return name;
    }

    //new end point for getting started
    @GetMapping("/saswade")
    public String workout() {
        return Saswade.getAssigndclass();
    }

    @GetMapping("/fortune")
    public String fortune() {
        return "you are not lucky  ";
    }

}
