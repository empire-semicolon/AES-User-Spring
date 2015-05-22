/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.Course;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface CourseDao {
    public void add(Course course);
    public void edit(Course course);
    public void delete(int courseId);
    public Course getById(int courseId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
    
}
