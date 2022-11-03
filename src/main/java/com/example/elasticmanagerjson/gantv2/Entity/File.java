package com.example.elasticmanagerjson.gantv2.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "gantt_file_upload")
@Getter
@Setter
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;

    @Column(name = "gantt_object_id")
    private Long ganttObjectId;

    public File() {

    }

    public File(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;

    }

    public File(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
        this.ganttObjectId = ganttObjectId;
    }

}
/**
 * Getters and Setters
 **/