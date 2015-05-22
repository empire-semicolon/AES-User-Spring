/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.util;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Properties;

/**
 *
 * @author Bryan Cabansay
 */
public class DbUtil {
    
    public Connection connection = null;
    
    public Connection getConnection(){
        if (connection != null){
            return connection;
        }
        else{
            try{
                Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("./db.properties");
                prop.load(inputStream);
                
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String pw = prop.getProperty("password");                
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, pw);                
                
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            return connection;            
        }
    }
    
    public boolean disconnect(){
        try{
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;       
    }
    
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
    
}
