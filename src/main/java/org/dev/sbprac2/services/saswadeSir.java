package org.dev.sbprac2.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class saswadeSir implements Teacher{

    @Override
    public String getTodaysSchedule() {
        return "saswadeSir : YOU WILL CUNDUCT 2 LECTURE AND 1 PRACTICAL";
    }

    @Override
    public String getAssigndclass() {
        return "CSE TY DIV B";
    }
}
