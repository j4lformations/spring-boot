package com.j4ltechnologies.sb.ormhbm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OrmHbmApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrmHbmApplication.class, args);
    }
}