package com.strikersoft.internal.teamcollaborationtool.app.repository;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final DatabaseClient databaseClient;

    public Mono<Long> create(UserDto userDto) {
        return databaseClient.sql("""
                        INSERT INTO users (name, email, password) VALUES (:name, :email, :password)
                        """)
                .filter(statement -> statement.returnGeneratedValues("id"))
                .bind("name", userDto.getName())
                .bind("email", userDto.getEmail())
                .bind("password", userDto.getPassword())
                .map((row, rowMetadata) -> {
                    System.out.println("vlad");
                    return -1L;
                })
                .one();
    }
}
