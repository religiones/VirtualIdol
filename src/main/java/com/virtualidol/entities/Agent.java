package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtualidol.entities.enumType.Job;
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

@Entity
@Table(name="agent_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Agent
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=32, unique=true)
    private String email;

    @Column(nullable=false, length=32, unique=true)
    private String phone;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team teamFk;

    @Column
    @Enumerated(EnumType.STRING)
    private Job teamJob;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userFk;

    public void setId(long agent_id)
    {
        this.id = agent_id;
    }

    public void setEmail(String agent_email) {
        this.email = agent_email;
    }

    public void setPhone(String agent_phone) {
        this.phone = agent_phone;
    }

    public void setTeamFk(Team agent_team_fk) {
        this.teamFk = agent_team_fk;
    }

    public void setTeamJob(Job agent_team_job) {
        this.teamJob = agent_team_job;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    public long getId()
    {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public Team getTeamFk() {
        return this.teamFk;
    }

    public Job getTeamJob() {
        return this.teamJob;
    }

    public User getUserFk() {
        return this.userFk;
    }
}