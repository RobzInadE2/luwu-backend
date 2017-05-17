package com.luwu.core.dto;

import com.luwu.core.validation.StringEnumeration;
import com.luwu.model.entity.User;
import io.dropwizard.validation.OneOf;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public class UserDto {

    private UserDto(){}

    private UUID id;

    @NotEmpty
    @Email(regexp = ".+@.+\\..+")
    private String email;

    @Valid
    @StringEnumeration(enumClass = User.Sex.class)
    private String sex;

    @NotNull
    private LocalDate birthday;

    @NotEmpty
    private String fullName;
    private String company;
    private String companyWebsite;
    private String companyLocation;
    private String jobTitle;

    public static UserDto fromDb(User user) {
        final UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.email = user.getEmail();
        userDto.sex = user.getSex().name();
        userDto.birthday = user.getBirthday();
        userDto.fullName = user.getFullName();
        userDto.company = user.getCompany();
        userDto.companyWebsite = user.getCompanyWebsite();
        userDto.companyLocation = user.getCompanyLocation();
        userDto.jobTitle = user.getJobTitle();
        return userDto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
