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
public class ExamBean {
    
    public int intExamId;
    public String strExamTitle;
    public Timestamp tsDateCreated;
    public Timestamp dateEdited;
    public String strQuestionDetails;
    public int intCourseId;
    public Timestamp tsExamDue;
    public float fTimeLimit;        

    public int getIntExamId() {
        return intExamId;
    }

    public void setIntExamId(int intExamId) {
        this.intExamId = intExamId;
    }

    public String getStrExamTitle() {
        return strExamTitle;
    }

    public void setStrExamTitle(String strExamTitle) {
        this.strExamTitle = strExamTitle;
    }

    public Timestamp getTsDateCreated() {
        return tsDateCreated;
    }

    public void setTsDateCreated(Timestamp tsDateCreated) {
        this.tsDateCreated = tsDateCreated;
    }

    public Timestamp getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(Timestamp dateEdited) {
        this.dateEdited = dateEdited;
    }

    public String getStrQuestionDetails() {
        return strQuestionDetails;
    }

    public void setStrQuestionDetails(String strQuestionDetails) {
        this.strQuestionDetails = strQuestionDetails;
    }

    public int getIntCourseId() {
        return intCourseId;
    }

    public void setIntCourseId(int intCourseId) {
        this.intCourseId = intCourseId;
    }

    public Timestamp getTsExamDue() {
        return tsExamDue;
    }

    public void setTsExamDue(Timestamp tsExamDue) {
        this.tsExamDue = tsExamDue;
    }

    public float getfTimeLimit() {
        return fTimeLimit;
    }

    public void setfTimeLimit(float fTimeLimit) {
        this.fTimeLimit = fTimeLimit;
    }

    @Override
    public String toString() {
        return "ExamBean{" + "intExamId=" + intExamId + ", strExamTitle=" + strExamTitle + ", tsDateCreated=" + tsDateCreated + ", dateEdited=" + dateEdited + ", strQuestionDetails=" + strQuestionDetails + ", intCourseId=" + intCourseId + ", tsExamDue=" + tsExamDue + ", fTimeLimit=" + fTimeLimit + '}';
    }

    
    
}
