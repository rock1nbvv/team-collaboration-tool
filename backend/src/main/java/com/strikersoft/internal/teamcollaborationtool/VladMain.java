package com.strikersoft.internal.teamcollaborationtool;

import com.strikersoft.internal.teamcollaborationtool.app.data.request.UserCreateDto;
import lombok.SneakyThrows;

/**
 * @author Vlad Baklaiev
 */
public class VladMain {

    @SneakyThrows
    public static void main(String[] args) {
        Class<UserCreateDto> myClass = UserCreateDto.class;
        System.out.println(myClass.getDeclaredConstructor(String.class, Integer.class, String.class, String.class).newInstance("vlad", 69, "impaler", "flux"));
    }
}
