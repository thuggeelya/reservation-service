package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner runner (ReservationRepository rr) {
        return args -> {
            Arrays.asList("Dr. Rodd, Dr. Sayer, Jurgen, ALL THE COMMUNITY, Josh".split(", "))
                    .forEach(x -> rr.save(new Reservation(x)));
            rr.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
