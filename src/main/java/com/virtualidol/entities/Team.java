package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="team_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=32)
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userFk;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(nullable=false, unique=true)
    private String logoUrl;

    public void setId(long team_id)
    {
        this.id = team_id;
    }

    public void setName(String team_name) {
        this.name = team_name;
    }

    public void setUserFk(User user) {
        this.userFk = user;
    }

    public void setBirthday(Date team_birthday) {
        this.birthday = team_birthday;
    }

    public void setLogoUrl(String team_logo_url) {
        this.logoUrl = team_logo_url;
    }

    public long getId()
    {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public User getUserFk() {
        return this.userFk;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }
}