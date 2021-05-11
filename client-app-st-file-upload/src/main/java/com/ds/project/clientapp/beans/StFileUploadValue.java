package com.ds.project.clientapp.beans;

import java.util.Date;


public class StFileUploadValue {

    private int file_id;
    private int st_id;
    private int class_id;
    private Date submitted_date;
    private String path;
    private String fileType;
    private byte[] data;

    public StFileUploadValue(int file_id, int st_id, int class_id, Date submitted_date, String path, String fileType, byte[] data) {
        this.file_id = file_id;
        this.st_id = st_id;
        this.class_id = class_id;
        this.submitted_date = submitted_date;
        this.path = path;
        this.fileType = fileType;
        this.data = data;
    }

    public StFileUploadValue() {
        this.file_id = file_id;
    }

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

    @Override
    public String toString() {
        return "StFileUploadValue{" +
                "file_id=" + file_id +
                ", st_id=" + st_id +
                ", class_id=" + class_id +
                ", submitted_date=" + submitted_date +
                ", path='" + path + '\'' +
                '}';
    }
}
