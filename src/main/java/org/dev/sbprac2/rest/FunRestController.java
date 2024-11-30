package org.dev.sbprac2.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {



    @Value("${my.name}")
    private String name;

    @GetMapping("/")
    public String index() {
        return name;
    }



    @GetMapping("/getstudent")
    public String check() {
        return "are saswade and bhai are same = ";
    }


}
