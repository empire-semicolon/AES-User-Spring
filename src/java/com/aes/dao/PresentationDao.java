/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.PresentationBean;
import com.aes.model.UserBean;
import com.aes.util.DbUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
public class PresentationDao {
    
    private DbUtil connection;
    
    public static void addPresentation (PresentationBean presentation){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into presentation (presentationID, fileName, "
                    + "fileType, fileSize, filePath, description, chapter_chapterId) values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, PresentationDao.getNextId());
            stmt.setString(2, presentation.getStrFileName());
            stmt.setString(3, presentation.getStrFileType());
            stmt.setDouble(4, presentation.getDblFileSize());
            stmt.setString(5, presentation.getStrFilePath());
            stmt.setString(6, presentation.getStrDescription());
            stmt.setInt(7, presentation.getIntChapterId());                        
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addPresentation PROBLEM");
            e.printStackTrace();
        }                        
    }

    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(presentationId) FROM presentation");
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
    
    public static List<PresentationBean> getAllPresentationByChapterId(int chapterId){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<PresentationBean> presentations = new ArrayList();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM presentation Where chapter_chapterId=?");
            stmt.setInt(1, chapterId);            
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()){
                PresentationBean temp = new PresentationBean();
                temp.setDblFileSize(rs.getDouble("fileSize"));
                temp.setIntChapterId(rs.getInt("chapter_chapterId"));
                temp.setIntPresentationId(rs.getInt("presentationId"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setStrDescription(rs.getString("description"));
                temp.setStrFileName(rs.getString("fileName"));
                temp.setStrFilePath(rs.getString("filePath"));
                temp.setStrFileType(rs.getString("fileType"));
                temp.setTsDateUploaded(rs.getTimestamp("dateUploaded"));               
                presentations.add(temp);                
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getAllPresentationByChapterId PROBLEM");
            e.printStackTrace();
            presentations = null;
        }
        return presentations;
    }
    
    public static List<PresentationBean> getAllPresentationByName(String fileName){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<PresentationBean> presentations = new ArrayList();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM presentation Where fileName like ?");
            stmt.setString(1, "%" + fileName + "%");            
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()){
                PresentationBean temp = new PresentationBean();
                temp.setDblFileSize(rs.getDouble("fileSize"));
                temp.setIntChapterId(rs.getInt("chapter_chapterId"));
                temp.setIntPresentationId(rs.getInt("presentationId"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setStrDescription(rs.getString("description"));
                temp.setStrFileName(rs.getString("fileName"));
                temp.setStrFilePath(rs.getString("filePath"));
                temp.setStrFileType(rs.getString("fileType"));
                temp.setTsDateUploaded(rs.getTimestamp("dateUploaded"));               
                presentations.add(temp);                
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getAllPresentationName PROBLEM");
            e.printStackTrace();
            presentations = null;
        }
        return presentations;
    }    
    
    public static PresentationBean getPresentationById(int presentationId){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM presentation Where presentationId=?");
            stmt.setInt(1, presentationId);            
            ResultSet rs = stmt.executeQuery();            
            if (rs.next()){
                PresentationBean temp = new PresentationBean();
                temp.setDblFileSize(rs.getDouble("fileSize"));
                temp.setIntChapterId(rs.getInt("chapter_chapterId"));
                temp.setIntPresentationId(rs.getInt("presentationId"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setStrDescription(rs.getString("description"));
                temp.setStrFileName(rs.getString("fileName"));
                temp.setStrFilePath(rs.getString("filePath"));
                temp.setStrFileType(rs.getString("fileType"));
                temp.setTsDateUploaded(rs.getTimestamp("dateUploaded"));               
                return temp;                
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getPresentationById PROBLEM");
            e.printStackTrace();           
        }
        return null;
    }
    
    public static void deletePresentation (PresentationBean presentation){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {                        
            PreparedStatement stmt = connection.prepareStatement("Delete from presentation where presentationId=?");
            stmt.setInt(1,presentation.getIntPresentationId());
            stmt.execute();            
            stmt.close();
            db.disconnect();
            PresentationDao.deleteFile(presentation.getStrFilePath());
        }
        catch (SQLException e){
            System.out.println("SQL deletePresentation PROBLEM");
            e.printStackTrace();
        }
    }
    
    public static void updatePresentation (PresentationBean presentation){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update presentation set "
                    + "fileName=?, fileType=?, fileSize=?, filePath=?, description=?, dateUploaded=?, chapter_chapterId=? "
                    + "where presentationId=?");                        
            stmt.setString(1, presentation.getStrFileName());
            stmt.setString(2, presentation.getStrFileType());
            stmt.setDouble(3, presentation.getDblFileSize());
            stmt.setString(4, presentation.getStrFilePath());
            stmt.setString(5, presentation.getStrDescription());
            stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(7, presentation.getIntChapterId());
            stmt.setInt(8, presentation.getIntPresentationId());            
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updatePresentation PROBLEM");
            e.printStackTrace();
        }
    }            
    
    //Delete file returns true if successfully delete false if not
    public static boolean deleteFile (String path){        
            File file = new File(path);
            if (file.delete()){
                return true;
            }
            return false;
    }
    /*
    public static void main (String[] args){
        
        PresentationBean presentation = new PresentationBean();
        presentation.setDblFileSize(69);
        presentation.setIntChapterId(11);
        presentation.setIntPresentationId(PresentationDao.getNextId());
        presentation.setStrDescription("Update Description");
        presentation.setStrFileName("Update File Name");
        presentation.setStrFilePath("Update File Path");
        presentation.setStrFileType("Update File Type");
        presentation.setIntPresentationId(13);
        //PresentationDao.updatePresentation(presentation);
        
        //PresentationDao.addPresentation(presentation);
        //presentation.setIntPresentationId(13);
        //PresentationDao.deletePresentation(presentation);
        
        List<PresentationBean> presentations = PresentationDao.getAllPresentationByName("Chapter");
        for (PresentationBean temp : presentations){
            System.out.println(temp);
        }    
        
        //System.out.println();        
    }*/
    
}
