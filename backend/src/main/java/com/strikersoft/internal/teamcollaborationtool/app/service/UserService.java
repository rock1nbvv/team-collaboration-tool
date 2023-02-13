package com.strikersoft.internal.teamcollaborationtool.app.service;

import com.strikersoft.internal.teamcollaborationtool.app.data.User;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserCreateDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserUpdateDto;
import com.strikersoft.internal.teamcollaborationtool.app.exception.NotFoundException;
import com.strikersoft.internal.teamcollaborationtool.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<Long> create(UserCreateDto userCreateDto) {
        User user = User.builder()
                .name(userCreateDto.getName())
                .email(userCreateDto.getEmail())
                .password(userCreateDto.getPassword())
                .build();
        return userRepository.create(user);
    }

    public Mono<UserDto> getById(Long id) {
        return userRepository.getById(id)
                .switchIfEmpty(Mono.error(() -> new NotFoundException("Entity " + User.class + " not found by id - " + id,
                        User.class,
                        id)));
    }

    public Mono<UserDto> updateById(Long id, UserUpdateDto userUpdateDto) {
        return userRepository.updateById(id, userUpdateDto)
                .switchIfEmpty(Mono.error(() -> new NotFoundException("Entity " + User.class + " not found by id - " + id,
                        User.class,
                        id)));
    }

    public Mono<Void> deleteById(Long id) {
        return userRepository.deleteById(id)
                .switchIfEmpty(Mono.error(() -> new NotFoundException("Entity " + User.class + " not found by id - " + id,
                        User.class,
                        id)))
                .then();
    }
}
