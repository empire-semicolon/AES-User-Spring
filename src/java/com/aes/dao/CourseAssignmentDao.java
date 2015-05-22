/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.CourseAssignmentBean;
import com.aes.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class CourseAssignmentDao {
    
    public static void assignCourse(CourseAssignmentBean assignment){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into courses_assigned values (?, ?, ?)");
            stmt.setInt(1, CourseAssignmentDao.getNextId());
            stmt.setInt(2, assignment.getIntUserId());
            stmt.setInt(3, assignment.getIntCourseId());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL assignCourse PROBLEM");
            e.printStackTrace();
        }
        
    }
        
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(assignmentId) FROM courses_assigned");
            ResultSet rs = stmt.executeQuery();  
            if (rs.next()){
                return rs.getInt(1)+1;
            }
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL getNextId PROBLEM");
            e.printStackTrace();
        }
        return 0;
    }    

    public static void removeAssignment(CourseAssignmentBean assignment){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Delete from courses_assigned where assignmentId=?");
            stmt.setInt(1, assignment.getIntAssignmentId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL removeAssignment PROBLEM");
            e.printStackTrace();
        }
        
    }                
    
    public static List<CourseAssignmentBean> getAllAssignedCourses(int userId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<CourseAssignmentBean> assignments = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from courses_assigned where user_details_userId=?");            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                CourseAssignmentBean temp = new CourseAssignmentBean();
                temp.setIntAssignmentId(rs.getInt("assignmentId"));
                temp.setIntCourseId(rs.getInt("course_courseId"));
                temp.setIntUserId(rs.getInt("user_details_userId"));
                assignments.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return assignments;
        }
        catch (SQLException e){
            System.out.println("SQL getAllAssigned PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    /*
    public static void main (String[] args){
        
        CourseAssignmentBean bean = new CourseAssignmentBean ();
        bean.setIntAssignmentId(5);
        bean.setIntCourseId(222);
        bean.setIntUserId(20158288);
        //CourseAssignmentDao.assignCourse(bean);
        //CourseAssignmentDao.removeAssignment(bean);
        
        /*
        List<CourseAssignmentBean> list = new ArrayList();
        
        list = CourseAssignmentDao.getAllAssignedCourses(20158288);
        
        
        for (CourseAssignmentBean temp : list){
            System.out.println(temp);
        }
        
        
        
    }*/
    
}
