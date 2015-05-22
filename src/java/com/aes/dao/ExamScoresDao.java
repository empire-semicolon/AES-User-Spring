/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;
import com.aes.model.ExamScores;
import java.util.List;
/**
 *
 * @author Bryan
 */
public interface ExamScoresDao {
    public void add(ExamScores score);
    public void edit(ExamScores score);
    public void delete(int scoreId);
    public ExamScores getById(int scoreId);
    public List getAll();
    public List getAllById(int userId);
    public int getNextId();
}
