package com.luwu.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User {

    public User() {
        this.id = UUID.randomUUID();
    }

    @Id
    private UUID id;

    private String email;
    private String passwordDigest;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    private LocalDate birthday;
    private String fullName;
    private String company;
    private String companyWebsite;
    private String companyLocation;
    private String jobTitle;

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
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

    public enum Sex {
        MALE,
        FEMALE;

        public static String[] SEXES = new String[] {""};
    }
}
