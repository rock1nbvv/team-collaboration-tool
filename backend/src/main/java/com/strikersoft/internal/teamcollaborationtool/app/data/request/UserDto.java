package com.strikersoft.internal.teamcollaborationtool.app.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Vlad Baklaiev
 */
@AllArgsConstructor
@Getter
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
