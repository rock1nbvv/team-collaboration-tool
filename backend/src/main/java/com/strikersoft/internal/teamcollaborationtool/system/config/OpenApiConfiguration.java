package com.strikersoft.internal.teamcollaborationtool.system.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

/**
 * @author Vlad Baklaiev
 */

//@Configuration
public class OpenApiConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("team-collaboration-tool")
                .packagesToScan("com.strikersoft.internal.teamcollaborationtool.app.controller")
                .build();
    }
}
