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
public class ExamDaoImpl implements ExamDao {

    HibernateUtil util = new HibernateUtil();
    Session session;
    
    @Override
    public void add(Exam exam) {
        try {
            exam.setExamId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(exam);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(Exam exam) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(exam);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void delete(int examId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(examId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public Exam getById(int examId) {
        Exam exam = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            exam = (Exam)session.get(Exam.class, examId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return exam;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            Criteria criteria = session.createCriteria(Exam.class);
            criteria.addOrder(Order.asc("examTitle"));
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
            Criteria criteria = session.createCriteria(Exam.class).setProjection(Projections.max("examId"));
            session.close();
            return (Integer)criteria.uniqueResult() + 1;            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return 0;
    }

    @Override
    public List searchName(String name) {
        List list = null;
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Exam.class);
            Criterion condition = Restrictions.like("examTitle", "%" + name + "%");      
            criteria.add(condition);         
            list = criteria.list();
            session.close();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return list;       
    }
    
}
