package com.strikersoft.internal.teamcollaborationtool.app.controller;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserCreateDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserUpdateDto;
import com.strikersoft.internal.teamcollaborationtool.app.data.response.ResponseWrapper;
import com.strikersoft.internal.teamcollaborationtool.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create user")
    public Mono<ResponseWrapper<Long>> create(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userCreateDto).map(ResponseWrapper::new);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get user")
    public Mono<ResponseWrapper<UserDto>> getById(@PathVariable Long userId) {
        return userService.getById(userId).map(ResponseWrapper::new);
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update user")
    public Mono<ResponseWrapper<UserDto>> updateById(@PathVariable Long userId, @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateById(userId, userUpdateDto).map(ResponseWrapper::new);
    }

    @DeleteMapping(value = "/{userId}")
    @Operation(summary = "Delete user")
    public Mono<ResponseWrapper<Void>> deleteById(@PathVariable Long userId) {
        return userService.deleteById(userId).map(userDto -> new ResponseWrapper<>(null));
    }
}
