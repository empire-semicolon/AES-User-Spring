/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.UserDetails;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface UserDetailsDao {
    public void add(UserDetails user);
    public void edit(UserDetails user);
    public void delete(int userId);
    public UserDetails getById(int userId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
}
