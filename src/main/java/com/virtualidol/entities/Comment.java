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
@Table(name="comment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=512)
    private String content;

    @ManyToOne
    @JoinColumn(name="work_id", nullable=false)
    private Work workFk;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userFk;

    @Column(nullable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public void setId(long comment_id)
    {
        this.id = comment_id;
    }

    public void setContent(String comment_content) {
        this.content = comment_content;
    }

    public void setWorkFk(Work comment_work_fk) {
        this.workFk = comment_work_fk;
    }

    public void setUserFk(User comment_user_fk) {
        this.userFk = comment_user_fk;
    }

    public void setTime(Date comment_time) {
        this.time = comment_time;
    }

    public long getId()
    {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public Work getWorkFk() {
        return this.workFk;
    }

    public User getUserFk() {
        return this.userFk;
    }

    public Date getTime() {
        return this.time;
    }
}