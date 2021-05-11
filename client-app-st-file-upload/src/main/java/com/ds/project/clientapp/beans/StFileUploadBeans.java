package com.ds.project.clientapp.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
@Component
@ConfigurationProperties(prefix = "st-file-upload")
public class StFileUploadBeans {

    private int file_id;
    private int st_id;
    private int class_id;
    private Date submitted_date;
    private String path;
    private String fileType;
    private byte[] data;
    private int port;

    public StFileUploadBeans() {

    }

    public StFileUploadBeans(int file_id, int st_id, int class_id, Date submitted_date, String path, String fileType, byte[] data, int port) {
        super();
        this.file_id = file_id;
        this.st_id = st_id;
        this.class_id = class_id;
        this.submitted_date = submitted_date;
        this.path = path;
        this.fileType = fileType;
        this.data = data;
        this.port = port;
    }

    public StFileUploadBeans(int file_id, int st_id, int class_id, Date submitted_date, String path, int port) {
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/tution1");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("hansani");
        return dataSourceBuilder.build();
    }
}
