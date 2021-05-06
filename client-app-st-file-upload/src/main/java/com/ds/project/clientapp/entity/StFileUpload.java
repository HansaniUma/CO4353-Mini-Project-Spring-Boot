package com.ds.project.clientapp.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@ConfigurationProperties(prefix = "file")
@Table(name = "stFileUpload")
@Entity
public class StFileUpload{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int file_id;

    @Column
    private int st_id;

    @Column
    private int class_id;

    @Column
    private Date submitted_date;

    @Column
    private String path;

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public Date getSubmitted_date() {
        return submitted_date;
    }

    public void setSubmitted_date(Date submitted_date) {
        this.submitted_date = submitted_date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
