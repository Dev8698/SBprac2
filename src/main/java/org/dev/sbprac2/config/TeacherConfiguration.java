package org.dev.sbprac2.config;

import org.dev.sbprac2.services.Teacher;
import org.dev.sbprac2.services.saswadeSir;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfiguration {

    @Bean
    public Teacher SaswadeSir() {
        return new saswadeSir();
    }

}
