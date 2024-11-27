package org.dev.sbprac2.services;

import org.springframework.stereotype.Component;

@Component
public class saswadeSir implements Teacher{

    @Override
    public String getTodaysSchedule() {
        return "YOU WILL CUNDUCT 2 LECTURE AND 1 PRACTICAL";
    }

    @Override
    public String getAssigndclass() {
        return "CSE TY DIV B";
    }
}
