package com.strikersoft.internal.teamcollaborationtool.app.controller;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import com.strikersoft.internal.teamcollaborationtool.app.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@RequestMapping("/users")
@RestController
@Tag(name = "Users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create user")
    public Mono<Void> createOld(@RequestBody UserDto userDto) {
        return userRepository.create(userDto)
                .flatMap(count -> {
                    return Mono.empty();
                })
                .then();
    }

//    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(description = "Create user")
//    public Mono<ResponseWrapper<Long>> create(@RequestBody UserDto userDto) {
//        return userService.create(userDto);
//    }

}
