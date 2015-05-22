/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.Chapter;
import java.util.List;

/**
 *
 * @author Bryan
 */
public interface ChapterDao {
    
    public void add(Chapter chapter);
    public void edit(Chapter chapter);
    public void delete(int chapterId);
    public Chapter getById(int chapterId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
    
}
