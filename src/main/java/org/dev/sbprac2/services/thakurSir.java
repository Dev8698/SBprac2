package org.dev.sbprac2.services;


import org.springframework.stereotype.Component;

@Component
public class thakurSir implements Teacher{
    @Override
    public String getTodaysSchedule() {
        return "YOU WILL CUNDUCT 4 LECTURE AND 2 PRACTICAL";
    }

    @Override
    public String getAssigndclass() {
        return "CSE SY DIV A";
    }
}