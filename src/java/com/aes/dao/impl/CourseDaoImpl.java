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
public class CourseDaoImpl implements CourseDao {

    HibernateUtil util = new HibernateUtil();
    Session session;
    
    @Override
    public void add(Course course) {
        try {
            course.setCourseId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(Course course) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void delete(int courseId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(courseId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public Course getById(int courseId) {
        Course course = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            course = (Course)session.get(Course.class, courseId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return course;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            Criteria criteria = session.createCriteria(Course.class);
            criteria.addOrder(Order.asc("courseTitle"));
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
            Criteria criteria = session.createCriteria(Course.class).setProjection(Projections.max("courseId"));
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
            Criteria criteria = session.createCriteria(Course.class);
            Criterion condition = Restrictions.like("courseTitle", "%" + name + "%");      
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
