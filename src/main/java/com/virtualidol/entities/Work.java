package com.virtualidol.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtualidol.entities.enumType.WorkSort;
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
@Table(name="work_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Work
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=128)
    private String name;

    @Column(nullable=false, unique=true)
    private String url;

    @Column(nullable=false, length=128)
    private String description;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private WorkSort sort;

    @Column(nullable=false, unique=true)
    private String coverUrl;

    @Column(length=128)
    private String tags;

    @Column(nullable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne
    @JoinColumn(name="idol_id", nullable=false)
    private Idol idolFk;

    @ManyToOne
    @JoinColumn(name="agent_id", nullable=false)
    private Agent agentFk;

    public void setId(long work_id)
    {
        this.id = work_id;
    }

    public void setName(String work_name) {
        this.name = work_name;
    }

    public void setUrl(String work_url) {
        this.url = work_url;
    }

    public void setDescription(String work_description) {
        this.description = work_description;
    }

    public void setSort(WorkSort work_sort) {
        this.sort = work_sort;
    }

    public void setCoverUrl(String work_cover_url) {
        this.coverUrl = work_cover_url;
    }

    public void setTags(String work_tags) {
        this.tags = work_tags;
    }

    public void setTime(Date work_time) {
        this.time = work_time;
    }

    public void setIdolFk(Idol work_idol_fk) {
        this.idolFk = work_idol_fk;
    }

    public void setAgentFk(Agent agentFK) {
        this.agentFk = agentFK;
    }

    public long getId()
    {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public WorkSort getSort() {
        return this.sort;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getTags() {
        return this.tags;
    }

    public Date getTime() {
        return this.time;
    }

    public Idol getIdolFk() {
        return this.idolFk;
    }

    public Agent getAgentFk() {
        return this.agentFk;
    }
}