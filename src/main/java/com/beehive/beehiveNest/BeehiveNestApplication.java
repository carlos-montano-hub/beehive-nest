package com.beehive.beehiveNest;

import com.beehive.beehiveNest.configuration.DatabaseInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO add a proper logger
@SpringBootApplication
public class BeehiveNestApplication {

    public static void main(String[] args) {
        //TODO Find a way to use spring here
        DatabaseInitializer.createDatabaseIfNotExists();
        SpringApplication.run(BeehiveNestApplication.class, args);
    }
}
