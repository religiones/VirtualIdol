package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtualidol.entities.enumType.Gender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=32, unique=true)
    private String name;

    @Column(nullable=false, length=32)
    private String password;

    @Column(nullable=false, length=32, unique=true)
    private String account;

    @Column(nullable=false, unique=true)
    private String profileUrl;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(nullable=false, length=32, unique=true)
    private String email;

    @Column(length=32, unique=true)
    private String phone;

    @Column(nullable=false, length=128)
    private String description;

    public void setId(long user_id)
    {
        this.id = user_id;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }

    public void setPassword(String user_password) {
        this.password = user_password;
    }

    public void setAccount(String user_account) {
        this.account = user_account;
    }

    public void setProfileUrl(String user_profile_url) {
        this.profileUrl = user_profile_url;
    }

    public void setSex(Gender user_sex) {
        this.sex = user_sex;
    }

    public void setEmail(String user_email) {
        this.email = user_email;
    }

    public void setPhone(String user_phone) {
        this.phone = user_phone;
    }

    public void setDescription(String user_description) {
        this.description = user_description;
    }

    public long getId()
    {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAccount() {
        return this.account;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public Gender getSex() {
        return this.sex;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getDescription() {
        return this.description;
    }
}