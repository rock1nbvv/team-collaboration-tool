package com.strikersoft.internal.teamcollaborationtool.app.data;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Baklaiev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    public User(UserDto userDto) {

    }
}
