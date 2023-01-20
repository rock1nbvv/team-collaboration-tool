package com.strikersoft.internal.teamcollaborationtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class TeamCollaborationToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamCollaborationToolApplication.class, args);
    }

}
