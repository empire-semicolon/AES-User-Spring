/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.Exam;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface ExamDao {
    public void add(Exam exam);
    public void edit(Exam exam);
    public void delete(int examId);
    public Exam getById(int examId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
}
