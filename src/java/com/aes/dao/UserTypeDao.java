/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.UserType;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface UserTypeDao {
    public void add(UserType userType);
    public void edit(UserType userType);
    public void delete(int userTypeId);
    public UserType getById(int userTypeId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
}
