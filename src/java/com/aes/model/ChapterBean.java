/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.model;

/**
 *
 * @author Bryan
 */
public class ChapterBean {
    
    public int intChapterId;
    public int intChapterNumber;
    public String strChapterTitle;
    public String strDescription;
    public int intCourseId;

    @Override
    public String toString() {
        return "ChapterBean{" + "intChapterId=" + intChapterId + ", intChapterNumber=" + intChapterNumber + ", strChapterTitle=" + strChapterTitle + ", strDescription=" + strDescription + ", intCourseId=" + intCourseId + '}';
    }    

    public int getIntChapterNumber() {
        return intChapterNumber;
    }

    public void setIntChapterNumber(int intChapterNumber) {
        this.intChapterNumber = intChapterNumber;
    }

    public String getStrChapterTitle() {
        return strChapterTitle;
    }

    public void setStrChapterTitle(String strChapterTitle) {
        this.strChapterTitle = strChapterTitle;
    }

    public int getIntChapterId() {
        return intChapterId;
    }

    public void setIntChapterId(int intChapterId) {
        this.intChapterId = intChapterId;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public int getIntCourseId() {
        return intCourseId;
    }

    public void setIntCourseId(int intCourseId) {
        this.intCourseId = intCourseId;
    }    
    
}
