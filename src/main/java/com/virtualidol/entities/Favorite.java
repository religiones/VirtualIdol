package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Favorite
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="work_id", nullable=false)
    private Work workFk;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userFk;

    public void setId(long favorite_id)
    {
        this.id = favorite_id;
    }

    public void setWorkFk(Work favorite_work_fk) {
        this.workFk = favorite_work_fk;
    }

    public void setUserFk(User favorite_user_fk) {
        this.userFk = favorite_user_fk;
    }

    public long getId()
    {
        return this.id;
    }

    public Work getWorkFk() {
        return this.workFk;
    }

    public User getUserFk() {
        return this.userFk;
    }
}