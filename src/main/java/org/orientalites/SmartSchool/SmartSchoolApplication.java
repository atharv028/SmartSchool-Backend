package org.orientalites.SmartSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SmartSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartSchoolApplication.class, args);
    }
}
