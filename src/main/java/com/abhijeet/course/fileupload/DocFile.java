package com.abhijeet.course.fileupload;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Where(clause = "is_deleted != true")
public class DocFile {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String fileName;
    private String downloadUrl;
    private double fileSize;
    private String fileType;
    private boolean is_deleted;

    public DocFile() {}

    public DocFile(String fileName, String downloadUrl, double fileSize, String fileType) {
        this.fileName = fileName;
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.is_deleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
