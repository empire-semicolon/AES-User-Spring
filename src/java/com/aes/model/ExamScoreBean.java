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
public class ExamScoreBean {    
    public int intExamScoreId;
    public Timestamp tsDateTaken;
    public int intScore;
    public int intMaxScore;
    public int intUserId;
    public int intExamId;   

    public int getIntExamScoreId() {
        return intExamScoreId;
    }

    public void setIntExamScoreId(int intExamScoreId) {
        this.intExamScoreId = intExamScoreId;
    }

    public Timestamp getTsDateTaken() {
        return tsDateTaken;
    }

    public void setTsDateTaken(Timestamp tsDateTaken) {
        this.tsDateTaken = tsDateTaken;
    }

    public int getIntScore() {
        return intScore;
    }

    public void setIntScore(int intScore) {
        this.intScore = intScore;
    }

    public int getIntUserId() {
        return intUserId;
    }

    public void setIntUserId(int intUserId) {
        this.intUserId = intUserId;
    }

    public int getIntExamId() {
        return intExamId;
    }

    public void setIntExamId(int intExamId) {
        this.intExamId = intExamId;
    }

    public int getIntMaxScore() {
        return intMaxScore;
    }

    public void setIntMaxScore(int intMaxScore) {
        this.intMaxScore = intMaxScore;
    }

    @Override
    public String toString() {
        return "ExamScoreBean{" + "intExamScoreId=" + intExamScoreId + ", tsDateTaken=" + tsDateTaken + ", intScore=" + intScore + ", intMaxScore=" + intMaxScore + ", intUserId=" + intUserId + ", intExamId=" + intExamId + '}';
    }
                
}
