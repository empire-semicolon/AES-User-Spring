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
public class CoursesAssignedDaoImpl implements CoursesAssignedDao {

    HibernateUtil util = new HibernateUtil();
    Session session;
    
    @Override
    public void add(CoursesAssigned assignment) {
        try {
            assignment.setAssignmentId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(assignment);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void edit(CoursesAssigned assignment) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(assignment);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        } 
    }

    @Override
    public void delete(int assignmentId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(assignmentId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }

    @Override
    public CoursesAssigned getById(int assignmentId) {
        CoursesAssigned assignment = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            assignment = (CoursesAssigned)session.get(CoursesAssigned.class,assignmentId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return assignment;
    }

    @Override
    public List getAll() {
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            Criteria criteria = session.createCriteria(CoursesAssigned.class);
            criteria.addOrder(Order.asc("assignmentId"));
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
            Criteria criteria = session.createCriteria(CoursesAssigned.class).setProjection(Projections.max("assignmentId"));
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
            Criteria criteria = session.createCriteria(CoursesAssigned.class);
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
