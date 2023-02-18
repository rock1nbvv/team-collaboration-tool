package com.strikersoft.internal.teamcollaborationtool.app.repository;

import com.strikersoft.internal.teamcollaborationtool.app.data.User;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserUpdateDto;
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

    private final DatabaseClient databaseClient;

    public Mono<Long> create(User user) {
        return databaseClient.sql("""
                        INSERT INTO users (name, email, password) VALUES (:name, :email, :password)
                        """)
                .filter(statement -> statement.returnGeneratedValues("id"))
                .bind("name", user.getName())
                .bind("email", user.getEmail())
                .bind("password", user.getPassword())
                .map((row, rowMetadata) -> (Long) row.get("id"))
                .one();
    }

    public Mono<UserDto> getById(Long id) {
        return databaseClient.sql("""
                        SELECT id, name, email FROM users
                        WHERE id=:id
                        """)
                .bind("id", id)
                .map((row, rowMetadata) -> UserDto.builder()
                        .id((Long) row.get("id"))
                        .name((String) row.get("name"))
                        .email((String) row.get("email"))
                        .build()
                )
                .first();
    }

    public Mono<UserDto> updateById(Long id, UserUpdateDto userUpdateDto) {
        return databaseClient.sql("""
                        UPDATE users
                        SET name=:name, email=:email, password=:password
                        WHERE id=:id
                        """)
                .bind("id", id)
                .bind("name", userUpdateDto.getName())
                .bind("email", userUpdateDto.getEmail())
                .bind("password", userUpdateDto.getPassword())
                .map((row, rowMetadata) -> UserDto.builder()
                        .id((Long) row.get("id"))
                        .name((String) row.get("name"))
                        .email((String) row.get("email"))
                        .build()
                )
                .first();
    }

    public Mono<Long> deleteById(Long id) {
        return databaseClient.sql("""
                        DELETE FROM users
                        WHERE id=:id
                        """)
                .bind("id", id)
                .fetch()
                .rowsUpdated();
    }
}
