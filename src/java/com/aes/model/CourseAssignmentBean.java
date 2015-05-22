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
public class CourseAssignmentBean {
    
    public int intAssignmentId;
    public int intUserId;
    public int intCourseId;

    public int getIntAssignmentId() {
        return intAssignmentId;
    }

    public void setIntAssignmentId(int intAssignmentId) {
        this.intAssignmentId = intAssignmentId;
    }

    public int getIntUserId() {
        return intUserId;
    }

    public void setIntUserId(int intUserId) {
        this.intUserId = intUserId;
    }

    public int getIntCourseId() {
        return intCourseId;
    }

    public void setIntCourseId(int intCourseId) {
        this.intCourseId = intCourseId;
    }

    @Override
    public String toString() {
        return "CourseAssignmentBean{" + "intAssignmentId=" + intAssignmentId + ", intUserId=" + intUserId + ", intCourseId=" + intCourseId + '}';
    }
    
    
    
}
