/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.CourseAssignmentBean;
import com.aes.model.ExamBean;
import com.aes.model.ExamScoreBean;
import com.aes.model.UserBean;
import com.aes.model.UserTypeBean;
import com.aes.util.DbUtil;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Cabansay
 */
public class UserDao {
    
    private DbUtil connection;
    
    public void add (){}
    public void delete (){}
    
    public static boolean isValid(UserBean user){
        
        boolean result = false;
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from user_details where userName=? and password=?");
            stmt.setString(1,user.getStrUserName());
            stmt.setString(2,user.getStrPassword());
            ResultSet rs = stmt.executeQuery();                        
            if (rs.next()){                
                return true;
            }
            rs.close();
            stmt.close();
            db.disconnect();
            
        }
        catch (SQLException e){
            System.out.println("SQL isValid PROBLEM");
            e.printStackTrace();
        }
        return result;
        
        
    }
    
    public static List<UserBean> getAllUsers(UserBean user){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<UserBean> users = new ArrayList();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM user_details "
                    + "WHERE userId NOT IN ( SELECT userId FROM user_details WHERE userId = ?) and recordStatus=1");
            stmt.setInt(1, user.getIntUserId());            
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()){
                UserBean temp = new UserBean();
                temp.setIntUserId(rs.getInt("userid"));
                temp.setStrUserName(rs.getString("username"));
                temp.setStrPassword(rs.getString("password"));
                temp.setStrFirstName(rs.getString("firstName"));
                temp.setStrMiddleName(rs.getString("middleName"));
                temp.setStrLastName(rs.getString("lastName"));
                temp.setDateBirthday(rs.getDate("birthday"));
                temp.setStrPosition(rs.getString("position"));
                temp.setStrEmail(rs.getString("email"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setIntUserTypeID(rs.getInt("user_type_userTypeId"));  
                temp.setStrBusinessUnit(rs.getString("business_unit"));
                temp.setIntCompanyId(rs.getInt("companyID"));
                users.add(temp);                
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getAllUsers PROBLEM");
            e.printStackTrace();
            users = null;
        }
        return users;        
    }

    
    public static void addUser(UserBean user){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Insert into user_details (username, "
                    + "password, firstName, middleName, lastName, birthday, position, email, dateCreated, "
                    + " user_type_userTypeId, userId, business_unit, companyID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, user.getStrUserName());
            stmt.setString(2, user.getStrPassword());
            stmt.setString(3, user.getStrFirstName());
            stmt.setString(4, user.getStrMiddleName());
            stmt.setString(5, user.getStrLastName());
            stmt.setDate(6, user.getDateBirthday());
            stmt.setString(7, user.getStrPosition());
            stmt.setString(8, user.getStrEmail());
            stmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(10, user.getIntUserTypeID());            
            stmt.setInt(11, user.getIntUserId());
            stmt.setString(12, user.getStrBusinessUnit());
            stmt.setInt(13, user.getIntCompanyId());
            stmt.execute();                      
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL addUser PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static void deleteUser(UserBean user){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {            
            PreparedStatement stmt = connection.prepareStatement("Update user_details set recordStatus=0 where userId=?");
            stmt.setInt(1,user.getIntUserId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL deleteUser PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static void updateUser(UserBean user){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update user_details set "
                    + "firstName=?, middleName=?, lastName=?, birthday=?, position=?, email=?, "
                    + "user_type_userTypeId=?, business_unit=? where userId=?");                                    
            stmt.setString(1, user.getStrFirstName());
            stmt.setString(2, user.getStrMiddleName());
            stmt.setString(3, user.getStrLastName());
            stmt.setDate(4, user.getDateBirthday());
            stmt.setString(5, user.getStrPosition());
            stmt.setString(6, user.getStrEmail());
            stmt.setInt(7, user.getIntUserTypeID());                        
            stmt.setString(8, user.getStrBusinessUnit());
            stmt.setInt(9, user.getIntUserId());
            stmt.execute();                   
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL updateUser PROBLEM");
            e.printStackTrace();
        }
        
    }
    
    public static UserBean getUserById(int userId){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from user_details where userId = ? LIMIT 1");
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
                                   
            if (rs.next()){                
                UserBean temp = new UserBean();
                temp.setIntUserId(rs.getInt("userid"));                
                temp.setStrUserName(rs.getString("username"));
                temp.setStrPassword(rs.getString("password"));
                temp.setStrFirstName(rs.getString("firstName"));
                temp.setStrMiddleName(rs.getString("middleName"));
                temp.setStrLastName(rs.getString("lastName"));
                temp.setDateBirthday(rs.getDate("birthday"));
                temp.setStrPosition(rs.getString("position"));
                temp.setStrEmail(rs.getString("email"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setIntUserTypeID(rs.getInt("user_type_userTypeId"));                                               
                temp.setStrBusinessUnit(rs.getString("business_unit"));
                //temp.setIntCompanyId(rs.getInt("companyID"));
                return temp;
            }                  
            rs.close();
            stmt.close();
            db.disconnect();                       
        }
        catch (SQLException e){
            System.out.println("SQL getUserById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }        

    public static UserBean getUserByUserName(String username){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();         
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from user_details where username = ?");
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
                                   
            if (rs.next()){                
                UserBean temp = new UserBean();
                temp.setIntUserId(rs.getInt("userid"));                
                temp.setStrUserName(rs.getString("username"));
                temp.setStrPassword(rs.getString("password"));
                temp.setStrFirstName(rs.getString("firstName"));
                temp.setStrMiddleName(rs.getString("middleName"));
                temp.setStrLastName(rs.getString("lastName"));
                temp.setDateBirthday(rs.getDate("birthday"));
                temp.setStrPosition(rs.getString("position"));
                temp.setStrEmail(rs.getString("email"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setIntUserTypeID(rs.getInt("user_type_userTypeId"));                                               
                temp.setStrBusinessUnit(rs.getString("business_unit"));
                temp.setIntCompanyId(rs.getInt("companyID"));
                return temp;
            }                  
            rs.close();
            stmt.close();
            db.disconnect();                       
        }
        catch (SQLException e){
            System.out.println("SQL getUserById PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }    

    public static List<UserBean> getUserByName(String name){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        List<UserBean> users = new ArrayList();
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Select * from user_details where firstName like ? or middleName like ? or lastName like ?");
            
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");
            stmt.setString(3, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
                                   
            while (rs.next()){                
                UserBean temp = new UserBean();
                temp.setIntUserId(rs.getInt("userid"));                
                temp.setStrUserName(rs.getString("username"));
                temp.setStrPassword(rs.getString("password"));
                temp.setStrFirstName(rs.getString("firstName"));
                temp.setStrMiddleName(rs.getString("middleName"));
                temp.setStrLastName(rs.getString("lastName"));
                temp.setDateBirthday(rs.getDate("birthday"));
                temp.setStrPosition(rs.getString("position"));
                temp.setStrEmail(rs.getString("email"));
                temp.setTsDateCreated(rs.getTimestamp("dateCreated"));
                temp.setIntRecordStatus(rs.getInt("recordStatus"));
                temp.setIntUserTypeID(rs.getInt("user_type_userTypeId"));                                               
                temp.setStrBusinessUnit(rs.getString("business_unit"));
                temp.setIntCompanyId(rs.getInt("companyID"));
                users.add(temp);
                System.out.println("niagi diri");
            }                  
            rs.close();
            stmt.close();
            db.disconnect();
            return users;
        }
        catch (SQLException e){
            System.out.println("SQL getUserByName PROBLEM");
            e.printStackTrace();
        }        
        return null;        
    }    
    
    public static int getNextId(){
        
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT MAX(userId) FROM user_details");
            ResultSet rs = stmt.executeQuery();  
            if (rs.next()){
                return rs.getInt(1)+1;
            }
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL  getNextId PROBLEM");
            e.printStackTrace();
        }
        return 0;
    }
    
    public static List<ExamScoreBean> getExamScores(UserBean user){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<ExamScoreBean> scores = new ArrayList();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM exam_scores where user_details_userId=?");
            stmt.setInt(1, user.getIntUserId());            
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()){
                ExamScoreBean temp = new ExamScoreBean();
                temp.setIntExamScoreId(rs.getInt("examId"));
                temp.setTsDateTaken(rs.getTimestamp("dateTaken"));
                temp.setIntScore(rs.getInt("score"));
                temp.setIntUserId(rs.getInt("user_details_userId"));
                temp.setIntExamId(rs.getInt("exam_examId"));
                temp.setIntMaxScore(rs.getInt("max_score"));
                scores.add(temp);
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getExamScores PROBLEM");
            e.printStackTrace();
            scores = null;
        }
        return scores;     
    }
    
    public static List<CourseAssignmentBean> getAssignedCourses(UserBean user){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();
        List<CourseAssignmentBean> courses = new ArrayList();
        
        try {
            PreparedStatement stmt = db.getConnection().prepareStatement("SELECT * FROM courses_assigned where user_details_userId=?");
            stmt.setInt(1, user.getIntUserId());            
            ResultSet rs = stmt.executeQuery();            
            while (rs.next()){
                CourseAssignmentBean bean = new CourseAssignmentBean();
                bean.setIntAssignmentId(rs.getInt("assignmentId"));
                bean.setIntCourseId(rs.getInt("course_courseId"));
                bean.setIntUserId(rs.getInt("user_details_userId"));
                courses.add(bean);
            }            
            rs.close();
            stmt.close();
            db.disconnect();                                    
        }
        catch (SQLException e){
            System.out.println("SQL getAssignCourses PROBLEM");
            e.printStackTrace();
            courses = null;
        }
        return courses;     
    }
    
    public static void resetUserPassword (UserBean user){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection(); 
        
        try {
            PreparedStatement stmt = connection.prepareStatement("Update user_details set password=? where userId=?");
            Properties prop = new Properties();
            InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("./default.properties");
            prop.load(inputStream);            
            stmt.setString(1, prop.getProperty("default_password"));
            stmt.setInt(2, user.getIntUserId());
            stmt.execute();            
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL ResetUserPassword PROBLEM");
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println("SQL ResetUserPassword PROBLEM");
            ex.printStackTrace();
        }        
    }
    
    public static String getUserType (int intUserTypeId){
        DbUtil db = new DbUtil();
        Connection connection = db.getConnection();        
        
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT userType FROM user_type where userTypeId=?");
            stmt.setInt(1, intUserTypeId);
            ResultSet rs = stmt.executeQuery();  
            if (rs.next()){
                return rs.getString("userType");
            }
            stmt.close();
            db.disconnect();            
        }
        catch (SQLException e){
            System.out.println("SQL getNextId PROBLEM");
            e.printStackTrace();
        }
        return "User type does not exist";
        
    }
    
     /*
    public static void main (String[] args){
        UserBean tem = new UserBean();
        
        Calendar currenttime = Calendar.getInstance();
        Date sqldate = new Date((currenttime.getTime()).getTime());
        UserBean temp = new UserBean();      
        temp.setIntUserId(20158288);
        temp.setStrUserName("bcabansay");
        temp.setStrPassword("alliance@123");
        System.out.println(UserDao.getUserByUserName("bcabansay"));
        
                temp.setStrUserName("Username123");
                temp.setStrPassword("password");
                temp.setStrFirstName("first name");
                temp.setStrMiddleName("middle name");
                temp.setStrLastName("last name");
                temp.setDateBirthday(sqldate);
                temp.setStrPosition("position");
                temp.setStrEmail("email");
                temp.setIntRecordStatus(1);
                temp.setIntUserTypeID(2); 
                temp.setIntUserId(1);
        UserDao.updateUser(temp);
        //System.out.println(UserDao.getNextId());                        
        
        List<ExamScoreBean> courses = UserDao.getExamScores(temp);        
        
       
        for (ExamScoreBean temp1 : courses){
            System.out.println(temp1);
        }      
        
        //System.out.println(UserDao.getUserType(temp.getIntUserTypeID()));
                
    }*/  
    
    
    
}


