package org.dev.sbprac2.services;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
public class thakurSir implements Teacher{
    @Override
    public String getTodaysSchedule() {
        return "thakurSir : YOU WILL CUNDUCT 4 LECTURE AND 2 PRACTICAL";
    }

    @Override
    public String getAssigndclass() {
        return "CSE SY DIV A";
    }
}
