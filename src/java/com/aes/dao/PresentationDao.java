/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.Presentation;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface PresentationDao {
    public void add(Presentation presentation);
    public void edit(Presentation presentation);
    public void delete(int presentationId);
    public Presentation getById(int presentationId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
}
