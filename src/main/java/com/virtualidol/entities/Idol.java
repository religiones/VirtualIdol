package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtualidol.entities.enumType.Gender;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="idol_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Idol
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=32, unique=true)
    private String name;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(nullable=false, unique=true)
    private String profileUrl;

    @Column
    private int height;

    @Column
    private int weight;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(length=128)
    private String hobby;

    @Column(length=128)
    private String speciality;

    @Column(length=128)
    private String description;

    @ManyToOne
    @JoinColumn(name="team_id", nullable=false)
    private Team teamFk;

    public void setId(long idol_id)
    {
        this.id = idol_id;
    }

    public void setName(String idol_name) {
        this.name = idol_name;
    }

    public void setSex(Gender idol_sex) {
        this.sex = idol_sex;
    }

    public void setProfileUrl(String idol_profile_url) {
        this.profileUrl = idol_profile_url;
    }

    public void setHeight(int idol_height) {
        this.height = idol_height;
    }

    public void setWeight(int idol_weight) {
        this.weight = idol_weight;
    }

    public void setBirthday(Date idol_birthday) {
        this.birthday = idol_birthday;
    }

    public void setHobby(String idol_hobby) {
        this.hobby = idol_hobby;
    }

    public void setSpeciality(String idol_speciality) {
        this.speciality = idol_speciality;
    }

    public void setDescription(String idol_description) {
        this.description = idol_description;
    }

    public void setTeamFk(Team idol_teamFk) {
        this.teamFk = idol_teamFk;
    }

    public long getId()
    {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Gender getSex() {
        return this.sex;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getHobby() {
        return this.hobby;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public String getDescription() {
        return this.description;
    }

    public Team getTeamFk() {
        return this.teamFk;
    }
}