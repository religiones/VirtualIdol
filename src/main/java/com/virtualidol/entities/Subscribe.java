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
@Table(name="subscribe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subscribe
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="idol_id", nullable=false)
    private Idol idolFk;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userFk;

    public void setId(long subscribe_id)
    {
        this.id = subscribe_id;
    }

    public void setIdolFk(Idol subscribe_idol_fk) {
        this.idolFk = subscribe_idol_fk;
    }

    public void setUserFk(User subscribe_user_fk) {
        this.userFk = subscribe_user_fk;
    }

    public long getId()
    {
        return this.id;
    }

    public Idol getIdolFk() {
        return this.idolFk;
    }

    public User getUserFk() {
        return this.userFk;
    }
}