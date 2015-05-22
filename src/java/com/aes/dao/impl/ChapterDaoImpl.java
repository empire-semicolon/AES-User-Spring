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
public class ChapterDaoImpl implements ChapterDao {

    HibernateUtil util = new HibernateUtil();
    Session session;
    
    @Override
    public void add(Chapter chapter) {
        try {
            chapter.setChapterId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(chapter);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(Chapter chapter) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(chapter);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void delete(int chapterId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(chapterId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public Chapter getById(int chapterId) {
        Chapter chapter = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            chapter = (Chapter)session.get(Chapter.class, chapterId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return chapter;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            List list = session.createCriteria(Chapter.class).list();
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
            Criteria criteria = session.createCriteria(Chapter.class).setProjection(Projections.max("chapterId"));
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
            Criteria criteria = session.createCriteria(Chapter.class);
            Criterion first = Restrictions.like("chapterTitle", "%" + name + "%");            
            criteria.add(first);                  
            criteria.addOrder(Order.asc("chapterTitle"));
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
