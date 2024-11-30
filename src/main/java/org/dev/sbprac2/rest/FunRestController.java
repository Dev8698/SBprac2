package org.dev.sbprac2.rest;


import org.dev.sbprac2.services.Teacher;
import org.dev.sbprac2.services.thakurSir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    Teacher Saswade;
    Teacher ThakurSir;
    @Autowired
    public FunRestController(@Qualifier("SaswadeSir") Teacher Saswade
    , @Qualifier("thakurSir") Teacher Thakur) {
        this.Saswade = Saswade;
        this.ThakurSir = Thakur;
    }

    @Value("${my.name}")
    private String name;

    @GetMapping("/")
    public String index() {
        return name;
    }

    @GetMapping("/check")
    public String check() {
        return "are saswade and bhai are same = ";
    }

    //new end point for getting started
    @GetMapping("/saswade")
    public String workout() {
        return Saswade.getTodaysSchedule();
    }

    @GetMapping("/thakur")
    public String thakur() {
        return ThakurSir.getTodaysSchedule();
    }

    @GetMapping("/fortune")
    public String fortune() {
        return "you are not lucky  ";
    }


}
