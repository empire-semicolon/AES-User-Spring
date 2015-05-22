/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao.impl;
import com.aes.util.HibernateUtil;
import com.aes.dao.*;
import com.aes.model.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bryan
 */
@Repository
public class ExamScoresDaoImpl implements ExamScoresDao {
   
    HibernateUtil util = new HibernateUtil();
    Session session;

    @Override
    public void add(ExamScores score) {
        try {
            score.setExamScoresId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(score);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(ExamScores score) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(score);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        } 
    }

    @Override
    public void delete(int scoreId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(scoreId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public ExamScores getById(int scoreId) {
        ExamScores unit = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            unit = (ExamScores)session.get(ExamScores.class, scoreId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return unit;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            Criteria criteria = session.createCriteria(ExamScores.class);
            criteria.addOrder(Order.asc("examScoresId"));
            List list = criteria.list();
            session.getTransaction().commit();
            session.close();
            return list; 
        } catch (Exception e){
            session.getTransaction().rollback();
            session.close();
        }
        return null;
    }
    
    @Override
    public int getNextId() {       
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            Criteria criteria = session.createCriteria(ExamScores.class).setProjection(Projections.max("examScoresId"));
            session.close();
            return (Integer)criteria.uniqueResult() + 1;            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return 0;        
    }

    @Override
    public List getAllById(int userId) {
        List list = null;
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            Criteria criteria = session.createCriteria(ExamScores.class);
            Criterion condition = Restrictions.eq("user_details_userId", userId);      
            criteria.add(condition);         
            list = criteria.list();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return list;
    }    
}
