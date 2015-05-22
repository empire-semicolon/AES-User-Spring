/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.ChapterBean;
import com.aes.model.CourseBean;
import com.aes.model.ExamBean;
import com.aes.model.ExamScoreBean;
import com.aes.model.PresentationBean;
import com.aes.model.UserBean;
import com.aes.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zeek
 */
public class User_DAO{
    public Iterable<CourseBean> getAllCourses(UserBean ub){
        ArrayList<CourseBean> alCourse = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from course inner join courses_assigned on course.courseId=courses_assigned.course_courseId where courses_assigned.user_details_userId=?;");
            stmt.setInt(1, ub.getIntUserId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                CourseBean cr = new CourseBean();
                cr.setIntCourseId(rs.getInt("courseId"));
                cr.setStrCourseOutline(rs.getString("courseOutline"));
                cr.setIntCategoryId(rs.getInt("courseCategoryId"));
                cr.setStrCourseTitle(rs.getString("courseTitle"));
                cr.setTsDateCreated(rs.getTimestamp("dateCreated"));
                cr.setTsLastEdited(rs.getTimestamp("lastEdited"));
                alCourse.add(cr);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alCourse;
    } 
    
    public Iterable<PresentationBean> getAllPresentations(ChapterBean ch){
        ArrayList<PresentationBean> alPresentations = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from presentation where chapter_chapterId=?;");
            stmt.setInt(1, ch.getIntChapterId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                PresentationBean pr = new PresentationBean();
                pr.setIntPresentationId(rs.getInt("presentationId"));
                pr.setStrFileName(rs.getString("fileName"));
                pr.setStrFileType(rs.getString("fileType"));
                pr.setStrDescription(rs.getString("description"));
                pr.setDblFileSize(rs.getDouble("fileSize"));
                pr.setIntRecordStatus(rs.getInt("recordStatus"));
                pr.setTsDateUploaded(rs.getTimestamp("dateUploaded"));
                pr.setStrFilePath(rs.getString("filePath"));
                pr.setIntChapterId(rs.getInt("chapter_chapterId"));
                alPresentations.add(pr);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alPresentations;
    }
    
    public boolean isValid(UserBean ub){
        boolean bCheck = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from user_details where userName=? and password=?;");
            stmt.setString(1, ub.getStrUserName());
            stmt.setString(2, ub.getStrPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
                bCheck = true;
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return bCheck;
    }
    
    public Iterable<ExamBean> getAllExamsOfCourse(CourseBean cr){
        ArrayList<ExamBean> alExam = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from exam where course_courseId=?;");
            stmt.setInt(1, cr.getIntCourseId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ExamBean ex = new ExamBean();
                ex.setIntExamId(rs.getInt("examId"));
                ex.setStrExamTitle(rs.getString("examTitle"));
                ex.setDateEdited(rs.getTimestamp("dateEdited"));
                ex.setIntCourseId(rs.getInt("course_courseId"));
                ex.setStrQuestionDetails(rs.getString("questionDetails"));
                ex.setTsExamDue(rs.getTimestamp("examDue"));
                ex.setfTimeLimit(rs.getFloat("timeLimit"));
                ex.setTsDateCreated(rs.getTimestamp("dateCreated"));
                alExam.add(ex);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alExam;
    }
    
    public Iterable<ChapterBean> getAllChapterOfCourse(CourseBean cr){
        ArrayList<ChapterBean> alChapter = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from chapter where course_courseId=?;");
            stmt.setInt(1, cr.getIntCourseId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ChapterBean cb = new ChapterBean();
                cb.setIntChapterId(rs.getInt("chapterId"));
                cb.setStrDescription(rs.getString("description"));
                cb.setIntCourseId(rs.getInt("course_courseId"));
                alChapter.add(cb);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alChapter;
    }
    
    public Iterable<CourseBean> searchCourse(String strChapterKeyword){
        ArrayList<CourseBean> alCourse = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from course where courseTitle like %?%;");
            stmt.setString(1, strChapterKeyword);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                CourseBean cr = new CourseBean();
                cr.setIntCourseId(rs.getInt("courseId"));
                cr.setStrCourseOutline(rs.getString("courseOutline"));
                cr.setIntCategoryId(rs.getInt("courseCategoryId"));
                cr.setStrCourseTitle(rs.getString("courseTitle"));
                cr.setTsDateCreated(rs.getTimestamp("dateCreated"));
                cr.setTsLastEdited(rs.getTimestamp("lastEdited"));
                alCourse.add(cr);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alCourse;
    }
    
    public Iterable<ExamScoreBean> getExamScores(UserBean ub){
        ArrayList<ExamScoreBean> alExamScore = new ArrayList();
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("select * from exam_scores where user_details_userId=?;");
            stmt.setInt(1, ub.getIntUserId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ExamScoreBean esb = new ExamScoreBean();
                esb.setIntExamId(rs.getInt("examId"));
                esb.setIntExamScoreId(rs.getInt("exam_examId"));
                esb.setIntMaxScore(rs.getInt("max_score"));
                esb.setIntScore(rs.getInt("score"));
                esb.setIntUserId(rs.getInt("user_details_userId"));
                esb.setTsDateTaken(rs.getTimestamp("dateTaken"));
                alExamScore.add(esb);
            }
            
            rs.close();
            stmt.close();
            db.disconnect();
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
        }
        
        return alExamScore;
    }
    
    public boolean updateProfile(UserBean ub){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try{
            PreparedStatement stmt = connection.prepareStatement("update user_details set userName=?, password=?, firstName=?, middleName=?, lastName=?, birthday=?, email=?, position=?, business_unit=? where user_details_userId=?;");
            stmt.setString(1, ub.getStrUserName());
            stmt.setString(1, ub.getStrPassword());
            stmt.setString(1, ub.getStrFirstName());
            stmt.setString(1, ub.getStrMiddleName());
            stmt.setString(1, ub.getStrLastName());
            stmt.setDate(1, ub.getDateBirthday());
            stmt.setString(1, ub.getStrEmail());
            stmt.setString(1, ub.getStrPosition());
            stmt.setString(1, ub.getStrBusinessUnit());
            stmt.setInt(1, ub.getIntUserId());
            
            stmt.executeUpdate();
            
            stmt.close();
            db.disconnect();
            
            return true;
        }
        catch(SQLException e){
            System.out.println("CONNECTION PROBLEM");
            e.printStackTrace();
            
            return false;
        }
    }
}
