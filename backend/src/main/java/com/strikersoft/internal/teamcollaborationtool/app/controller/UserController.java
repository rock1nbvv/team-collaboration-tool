package com.strikersoft.internal.teamcollaborationtool.app.controller;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserCreateDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.response.ResponseWrapper;
import com.strikersoft.internal.teamcollaborationtool.app.repository.UserRepository;
import com.strikersoft.internal.teamcollaborationtool.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@RequestMapping("/user")
@RestController
@Tag(name = "User")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    @PostMapping(value="/vlad", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create user")
    public Mono<Long> createOld(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto)
                .flatMap(Mono::just);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Create user")
    public Mono<ResponseWrapper<Long>> create(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto).map(ResponseWrapper::new);
    }

}
