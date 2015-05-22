  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.CourseBean;
import com.aes.model.UserBean;
import com.aes.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class CourseDao {
    
    private DbUtil db;
    
    public static void addCourse(CourseBean course){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into course values (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, CourseDao.getNextId());
            stmt.setString(2, course.getStrCourseTitle());
            stmt.setString(3, course.getStrCourseOutline());
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(6, course.getIntCategoryId());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addCourse PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static void updateCourse(CourseBean course){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update course set "
                    + "course_title=?, course_outline=?, lastEdited=?, course_category_courseCategoryId=? where courseId=?");                                    
            
            stmt.setString(1, course.getStrCourseTitle());
            stmt.setString(2, course.getStrCourseOutline());
            stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(4, course.getIntCategoryId());
            stmt.setInt(5, course.getIntCourseId());
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updateCourse PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(courseId) FROM course");
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

    public static void deleteCourse(CourseBean course){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Delete from course where courseId=?");
            stmt.setInt(1,course.getIntCourseId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL deleteCourse PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static CourseBean getCourseById(int courseId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from course where courseId = ?");
            
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
                                   
            if (rs.next()){                
                CourseBean temp = new CourseBean();
                temp.setIntCategoryId(rs.getInt("course_category_courseCategoryId"));
                temp.setIntCourseId(rs.getInt("courseId"));
                temp.setStrCourseTitle(rs.getString("course_title"));
                temp.setStrCourseOutline(rs.getString("course_outline"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setTsLastEdited(rs.getTimestamp("lastEdited"));
                return temp;
            }                  
            rs.close();
            stmt.close();
            db.disconnect();                       
        }
        catch (SQLException e){
            System.out.println("SQL getCourseById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    public static List<CourseBean> getCourseByName(String name){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<CourseBean> courses = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from course where course_title like ?");            
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                CourseBean temp = new CourseBean();
                temp.setIntCategoryId(rs.getInt("course_category_courseCategoryId"));
                temp.setIntCourseId(rs.getInt("courseId"));
                temp.setStrCourseTitle(rs.getString("course_title"));
                temp.setStrCourseOutline(rs.getString("course_outline"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setTsLastEdited(rs.getTimestamp("lastEdited"));
                courses.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return courses;
        }
        catch (SQLException e){
            System.out.println("SQL getCoursesByName PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    public static List<CourseBean> getAllCourses(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<CourseBean> courses = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from course");            
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                CourseBean temp = new CourseBean();
                temp.setIntCategoryId(rs.getInt("course_category_courseCategoryId"));
                temp.setIntCourseId(rs.getInt("courseId"));
                temp.setStrCourseTitle(rs.getString("course_title"));
                temp.setStrCourseOutline(rs.getString("course_outline"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setTsLastEdited(rs.getTimestamp("lastEdited"));
                courses.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return courses;
        }
        catch (SQLException e){
            System.out.println("SQL getAllCourses PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    /*
    public static void main (String[] args){
        
        CourseBean course = new CourseBean();
        course.setIntCategoryId(2);
        course.setIntCourseId(556);
        course.setStrCourseOutline("Outline ni nga updated");
        course.setStrCourseTitle("Title ni siya nga updated");
        //CourseDao.addCourse(course);
        //CourseDao.updateCourse(course);
        CourseDao.deleteCourse(course);
                
        
        List<CourseBean> courses = new ArrayList();
        courses = CourseDao.getCourseByName("t");
        
        for (CourseBean temp : courses){
            System.out.println(temp);
        }
                
        
    }*/
    
}
