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
public class CourseCategoryDaoImpl implements CourseCategoryDao {

    HibernateUtil util = new HibernateUtil();
    Session session;
    
    @Override
    public void add(CourseCategory category) {
        try {
            category.setCourseCategoryId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(CourseCategory category) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        } 
    }

    @Override
    public void delete(int categoryId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(categoryId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public CourseCategory getById(int categoryId) {
        CourseCategory category = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            category = (CourseCategory)session.get(CourseCategory.class, categoryId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return category;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            Criteria criteria = session.createCriteria(CourseCategory.class);
            criteria.addOrder(Order.asc("courseCategory"));
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
            Criteria criteria = session.createCriteria(CourseCategory.class).setProjection(Projections.max("courseCategoryId"));
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
            Criteria criteria = session.createCriteria(CourseCategory.class);
            Criterion condition = Restrictions.like("courseCategory", "%" + name + "%");      
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
