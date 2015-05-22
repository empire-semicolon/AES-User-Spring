/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.CoursesAssigned;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface CoursesAssignedDao {
    public void add(CoursesAssigned assignment);
    public void edit(CoursesAssigned assignment);
    public void delete(int assignmentId);
    public CoursesAssigned getById(int assignmentId);
    public List getAll();
    public List getAllById(int userId);
    public int getNextId();  
}
