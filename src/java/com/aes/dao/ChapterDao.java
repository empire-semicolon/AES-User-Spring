/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.ChapterBean;
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
public class ChapterDao {
    
    public static void addChapter(ChapterBean chapter){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into chapter values (?, ?, ?, ?, ?)");
            stmt.setInt(1, ChapterDao.getNextId());
            stmt.setString(2, chapter.getStrDescription());
            stmt.setInt(3, chapter.getIntCourseId());
            stmt.setInt(4, chapter.getIntChapterNumber());
            stmt.setString(5, chapter.getStrChapterTitle());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addChapter PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static void updateChapter(ChapterBean chapter){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update chapter set description=?, course_courseId=?, "
                    + "chapterNumber=?, chapterTitle=? where chapterId=?");                                    
            
            stmt.setString(1, chapter.getStrDescription());
            stmt.setInt(2, chapter.getIntCourseId());
            stmt.setInt(3, chapter.getIntChapterNumber());
            stmt.setString(4, chapter.getStrChapterTitle());
            stmt.setInt(5, chapter.getIntChapterId());
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updateChapter PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(chapterId) FROM chapter");
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

    public static void deleteChapter(ChapterBean chapter){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Delete from chapter where chapterId=?");
            stmt.setInt(1, chapter.getIntChapterId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL deleteChapter PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static ChapterBean getChapterById(int chapterId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from chapter where chapterId=?");
            
            stmt.setInt(1, chapterId);
            ResultSet rs = stmt.executeQuery();
                                   
            if (rs.next()){                
                ChapterBean temp = new ChapterBean();
                temp.setIntChapterId(rs.getInt("chapterId"));
                temp.setIntChapterNumber(rs.getInt("chapterNumber"));
                temp.setIntCourseId(rs.getInt("course_courseId"));
                temp.setStrChapterTitle(rs.getString("chapterTitle"));
                temp.setStrDescription(rs.getString("description"));
                return temp;
            }                  
            rs.close();
            stmt.close();
            db.disconnect();                       
        }
        catch (SQLException e){
            System.out.println("SQL getChapterById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    
    
    public static List<ChapterBean> getAllChaptersByCourse(int courseId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<ChapterBean> courses = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from chapter where course_courseId=?");            
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                ChapterBean temp = new ChapterBean();
                temp.setIntChapterId(rs.getInt("chapterId"));
                temp.setIntChapterNumber(rs.getInt("chapterNumber"));
                temp.setIntCourseId(rs.getInt("course_courseId"));
                temp.setStrChapterTitle(rs.getString("chapterTitle"));
                temp.setStrDescription(rs.getString("description"));
                courses.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return courses;
        }
        catch (SQLException e){
            System.out.println("SQL getAllChaptersByCourse PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    public static List<Integer> getAllChapterNumbers(int courseId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<Integer> numbers = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select chapterNumber from chapter where course_courseId=? order by chapterNumber ASC");            
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                 
                numbers.add((Integer)rs.getInt("chapterNumber"));                
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return numbers;
        }
        catch (SQLException e){
            System.out.println("SQL getAllChaptersByCourse PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }    
   
    /*
    public static void main (String[] args){        
        List<Integer> list = ChapterDao.getAllChapterNumbers(555);
        for (Integer temp : list){
            System.out.println(temp);
        }                
    } 
    */
}
