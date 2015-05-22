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
public class CourseCategoryBean {
    
    public int intCourseCategoryId;
    public String strCourseCategory;

    public int getIntCourseCategoryId() {
        return intCourseCategoryId;
    }

    public void setIntCourseCategoryId(int intCourseCategoryId) {
        this.intCourseCategoryId = intCourseCategoryId;
    }

    public String getStrCourseCategory() {
        return strCourseCategory;
    }

    public void setStrCourseCategory(String strCourseCategory) {
        this.strCourseCategory = strCourseCategory;
    }

    @Override
    public String toString() {
        return "CourseCategoryBean{" + "intCourseCategoryId=" + intCourseCategoryId + ", strCourseCategory=" + strCourseCategory + '}';
    }
    
}
