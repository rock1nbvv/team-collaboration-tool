package com.strikersoft.internal.teamcollaborationtool.app.data.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vlad Baklaiev
 */
@AllArgsConstructor
@Getter
public class UserUpdateDto {
    private String name;
    private String email;
    private String password;
}
