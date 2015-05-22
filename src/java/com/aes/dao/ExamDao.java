/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.ExamBean;
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
public class ExamDao {

    public static void addExam(ExamBean exam){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into exam values (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, ExamDao.getNextId());
            stmt.setString(2, exam.getStrExamTitle());
            stmt.setTimestamp(3, DbUtil.getCurrentTime());
            stmt.setTimestamp(4, DbUtil.getCurrentTime());
            stmt.setString(5, exam.getStrQuestionDetails());
            stmt.setInt(6, exam.getIntCourseId());
            stmt.setTimestamp(7, exam.getTsExamDue());
            stmt.setFloat(8, exam.getfTimeLimit());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addExamBean PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static void updateExam(ExamBean chapter){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update exam set "
                    + "examTitle=?, dateEdited=?, questionDetails=?, course_courseId=?, "
                    + "examDue=?, timeLimit=? where examId=?");
            
            stmt.setString(1, chapter.getStrExamTitle());
            stmt.setTimestamp(2, DbUtil.getCurrentTime());
            stmt.setString(3, chapter.getStrQuestionDetails());
            stmt.setInt(4, chapter.getIntCourseId());
            stmt.setTimestamp(5, chapter.getTsExamDue());
            stmt.setFloat(6, chapter.getfTimeLimit());
            stmt.setInt(7, chapter.getIntExamId());
                        
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updateExam PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(examId) FROM exam");
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

    public static void deleteExam(ExamBean exam){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Delete from exam where examId=?");
            stmt.setInt(1, exam.getIntExamId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL deleteExam PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static ExamBean getExamById(int examId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from exam where examId = ?");            
            stmt.setInt(1, examId);
            ResultSet rs = stmt.executeQuery();
                                   
            if (rs.next()){                
                ExamBean temp = new ExamBean();
                temp.setDateEdited(rs.getTimestamp("dateEdited"));
                temp.setIntCourseId(rs.getInt("course_courseId"));
                temp.setIntExamId(rs.getInt("examId"));
                temp.setStrExamTitle(rs.getString("examTitle"));
                temp.setStrQuestionDetails(rs.getString("questionDetails"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setTsExamDue(rs.getTimestamp("examDue"));
                temp.setfTimeLimit(rs.getFloat("timeLimit"));
                return temp;
            }                  
            rs.close();
            stmt.close();
            db.disconnect();              
        }
        catch (SQLException e){
            System.out.println("SQL getExamById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    
    /*
    public static List<ExamBean> getAllExamsByCourse(int courseId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<ExamBean> courses = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from exam where course_courseId=?");            
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                ExamBean temp = new ExamBean();
                temp.setDateEdited(rs.getTimestamp("dateEdited"));
                temp.setIntCourseId(rs.getInt("course_courseId"));
                temp.setIntExamId(rs.getInt("examId"));
                temp.setStrExamTitle(rs.getString("examTitle"));
                temp.setStrQuestionDetails(rs.getString("questionDetails"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setTsExamDue(rs.getTimestamp("examDue"));
                temp.setfTimeLimit(rs.getFloat("timeLimit"));
                courses.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return courses;
        }
        catch (SQLException e){
            System.out.println("SQL getAllExamsByCourse PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    
    public static void main (String[] args){
        
        ExamBean exams = new ExamBean();
        exams.setIntExamId(3);
        exams.setStrExamTitle("title updated");
        exams.setStrQuestionDetails("DETAILS updated");
        exams.setIntCourseId(111);
        exams.setTsExamDue(DbUtil.getCurrentTime());
        exams.setfTimeLimit(26.0f);
        ExamDao.deleteExam(exams);
        
        System.out.println(exams);
        
        
    }*/
    
}
