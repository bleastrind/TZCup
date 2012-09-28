package net.tiaozhanbei.model;

import java.util.Date;


/**
 * ProjectFile entity. @author MyEclipse Persistence Tools
 */

public class ProjectFile  implements java.io.Serializable {


    // Fields    

     private Integer fileId;
     private String fileName;
     private String filePath;
     private Integer fileSource;
     private Date fileTime;
     private String fileDescription;
     private Integer fileType;


    // Constructors

    /** default constructor */
    public ProjectFile() {
    }

	/** minimal constructor */
    public ProjectFile(Integer fileId, String fileName, String filePath, Integer fileSource) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSource = fileSource;
    }
    
    /** full constructor */
    public ProjectFile(Integer fileId, String fileName, String filePath, Integer fileSource, Date fileTime, String fileDescription, Integer fileType) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSource = fileSource;
        this.fileTime = fileTime;
        this.fileDescription = fileDescription;
        this.fileType = fileType;
    }

   
    // Property accessors

    public Integer getFileId() {
        return this.fileId;
    }
    
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileSource() {
        return this.fileSource;
    }
    
    public void setFileSource(Integer fileSource) {
        this.fileSource = fileSource;
    }

    public Date getFileTime() {
        return this.fileTime;
    }
    
    public void setFileTime(Date fileTime) {
        this.fileTime = fileTime;
    }

    public String getFileDescription() {
        return this.fileDescription;
    }
    
    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Integer getFileType() {
        return this.fileType;
    }
    
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
   








}