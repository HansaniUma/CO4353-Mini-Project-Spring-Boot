package com.ds.project.clientapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENTFILE_TBL")
public class StudentFile {

    @Id
    @GeneratedValue
    private int fileId;
    private int classId;
    private int studentID;
    private String lessonName;
    private String filePath;
}
