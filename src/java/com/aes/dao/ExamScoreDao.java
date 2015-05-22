/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.ExamScoreBean;
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
public class ExamScoreDao {

    public static void addExamScore(ExamScoreBean examScore){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into exam_scores values (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, ExamScoreDao.getNextId());
            stmt.setTimestamp(2, DbUtil.getCurrentTime());
            stmt.setInt(3, examScore.getIntScore());
            stmt.setInt(4, examScore.getIntMaxScore());
            stmt.setInt(5,examScore.getIntUserId());
            stmt.setInt(6, examScore.getIntExamId());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addExamScore PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    
    //No Update Score since you cant change the result
    /*
    public static void updateScore(ExamScoreBean chapter){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update exam_scores set "
                    + "");
            
     
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updateExam PROBLEM");
            e.printStackTrace();
        }
        
    }*/
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(examId) FROM exam_scores");
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

    public static void deleteExamScore(ExamScoreBean score){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Delete from exam_scores where examId=?");
            stmt.setInt(1, score.getIntExamScoreId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL deleteScore PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static List<ExamScoreBean> getExamScoreById(int userid){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        List<ExamScoreBean> scores = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from exam_scores where user_details_userId = ?");            
            stmt.setInt(1, userid);
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                ExamScoreBean temp = new ExamScoreBean();                
                temp.setIntExamId(rs.getInt("exam_examId"));
                temp.setIntExamScoreId(rs.getInt("examId"));
                temp.setIntMaxScore(rs.getInt("max_score"));
                temp.setIntScore(rs.getInt("score"));
                temp.setIntUserId(rs.getInt("user_details_userId"));
                temp.setTsDateTaken(rs.getTimestamp("dateTaken"));
                scores.add(temp);
            }                  
            rs.close();
            stmt.close();
            db.disconnect();    
            return scores;
        }
        catch (SQLException e){
            System.out.println("SQL getExamScoreById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }
    
    public static void main(String[] args){
        
        ExamScoreBean score = new ExamScoreBean();
        score.setIntExamId(1);
        score.setIntExamScoreId(4);
        score.setIntMaxScore(70);
        score.setIntScore(58);
        score.setIntUserId(20158288);
        score.setTsDateTaken(DbUtil.getCurrentTime());
        
        ExamScoreDao.deleteExamScore(score);
        
        
        /*
        //List<ExamScoreBean> scores = new ArrayList();
        //scores = ExamScoreDao.getExamScoreById(20151234);
        
        for (ExamScoreBean temp : scores){
            System.out.println(temp);
        }*/
    }
    
     
}
