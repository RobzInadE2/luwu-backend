package com.luwu.web.api.dto;

import com.luwu.core.dto.UserDto;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegistrationDto {

    @Valid
    @NotNull
    private UserDto user;

    @NotEmpty
    @Length(min = 6)
    private String desiredPassword;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getDesiredPassword() {
        return desiredPassword;
    }

    public void setDesiredPassword(String desiredPassword) {
        this.desiredPassword = desiredPassword;
    }
}
