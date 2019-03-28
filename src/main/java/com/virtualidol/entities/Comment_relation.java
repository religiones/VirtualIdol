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
@Table(name="comment_relation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment_relation
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=512)
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userFk;

    @ManyToOne
    @JoinColumn(name="comment_id", nullable=false)
    private Comment commentFk;

    @ManyToOne
    @JoinColumn(name="work_id", nullable=false)
    private Work workFk;

    @Column(nullable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public void setId(long relation_id)
    {
        this.id = relation_id;
    }

    public void setContent(String relation_content) {
        this.content = relation_content;
    }

    public void setUserFk(User relation_user_fk) {
        this.userFk = relation_user_fk;
    }

    public void setCommentFk(Comment relation_comment_fk) {
        this.commentFk = relation_comment_fk;
    }

    public void setWorkFk(Work relation_work_fk) {
        this.workFk = relation_work_fk;
    }

    public void setTime(Date relation_time) {
        this.time = relation_time;
    }

    public long getId()
    {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }

    public User getUserFk() {
        return this.userFk;
    }

    public Comment getCommentFk() {
        return this.commentFk;
    }

    public Work getWorkFk() {
        return this.workFk;
    }

    public Date getTime() {
        return this.time;
    }
}