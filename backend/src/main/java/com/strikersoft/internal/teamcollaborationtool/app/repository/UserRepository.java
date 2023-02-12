package com.strikersoft.internal.teamcollaborationtool.app.repository;

import com.strikersoft.internal.teamcollaborationtool.app.data.User;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@RequiredArgsConstructor
@Repository
public class UserRepository {
    @Autowired
    private final DatabaseClient databaseClient;

    public Mono<Long> create(User user) {
        return databaseClient.sql("""
                        INSERT INTO users (name, email, password) VALUES (:name, :email, :password)
                        """)
                .filter(statement -> statement.returnGeneratedValues("id"))
                .bind("name", user.getName())
                .bind("email", user.getEmail())
                .bind("password", user.getPassword())
                .map((row, rowMetadata) -> {
                    System.out.println("vlad");
                    return -1L;
                })
                .one();
    }
}
