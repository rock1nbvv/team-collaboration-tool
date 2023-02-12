package com.strikersoft.internal.teamcollaborationtool.app.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Baklaiev
 */
@Getter
@NoArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
}
