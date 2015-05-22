/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.service;

import com.aes.dao.User_DAO;
import com.aes.model.UserBean;
import com.aes.model.CourseBean;

/**
 *
 * @author zeek
 */
public class User_Service {
    private User_DAO ud = new User_DAO();
    
    public Iterable<CourseBean> getAllCourses(UserBean ub){
        return (Iterable<CourseBean>) ud.getAllCourses(ub);
    }
}
