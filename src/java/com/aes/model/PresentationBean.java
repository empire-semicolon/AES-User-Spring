/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.model;

import java.sql.Timestamp;

/**
 *
 * @author Bryan
 */
public class PresentationBean {
    
    public int intPresentationId;
    public String strFileName;
    public String strFileType;
    public String strDescription;
    public double dblFileSize;
    public Timestamp tsDateUploaded;
    public int intRecordStatus;
    public int intChapterId;
    public String strFilePath;

    public int getIntPresentationId() {
        return intPresentationId;
    }

    public String getStrFilePath() {
        return strFilePath;
    }

    public void setStrFilePath(String strFilePath) {
        this.strFilePath = strFilePath;
    }            

    public void setIntPresentationId(int intPresentationId) {
        this.intPresentationId = intPresentationId;
    }

    public String getStrFileName() {
        return strFileName;
    }

    public void setStrFileName(String strFileName) {
        this.strFileName = strFileName;
    }

    public String getStrFileType() {
        return strFileType;
    }

    public void setStrFileType(String strFileType) {
        this.strFileType = strFileType;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public double getDblFileSize() {
        return dblFileSize;
    }

    public void setDblFileSize(double dblFileSize) {
        this.dblFileSize = dblFileSize;
    }    

    public Timestamp getTsDateUploaded() {
        return tsDateUploaded;
    }

    public void setTsDateUploaded(Timestamp tsDateUploaded) {
        this.tsDateUploaded = tsDateUploaded;
    }

    public int getIntRecordStatus() {
        return intRecordStatus;
    }

    public void setIntRecordStatus(int intRecordStatus) {
        this.intRecordStatus = intRecordStatus;
    }

    public int getIntChapterId() {
        return intChapterId;
    }

    public void setIntChapterId(int intChapterId) {
        this.intChapterId = intChapterId;
    }

    @Override
    public String toString() {
        return "PresentationBean{" + "intPresentationId=" + intPresentationId + ", strFileName=" + strFileName + ", strFileType=" + strFileType + ", strDescription=" + strDescription + ", dblFileSize=" + dblFileSize + ", tsDateUploaded=" + tsDateUploaded + ", intRecordStatus=" + intRecordStatus + ", intChapterId=" + intChapterId + ", strFilePath=" + strFilePath + '}';
    }             
    
}
