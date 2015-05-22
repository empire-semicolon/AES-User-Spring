/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao.impl;
import com.aes.util.HibernateUtil;
import com.aes.dao.*;
import com.aes.model.*;
import static java.util.Collections.list;
import java.util.List;
import javax.transaction.Transactional;
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
public class UserDetailsDaoImpl implements UserDetailsDao {
        
    
    HibernateUtil util = new HibernateUtil();
    Session session;
    @Autowired
    private SessionFactory factory;

    @Override
    public void add(UserDetails user) {
        try {
            user.setUserId(getNextId());
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }       
    }

    @Override
    public void edit(UserDetails user) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }     
    }

    @Override
    public void delete(int userId) {
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            session.delete(getById(userId));
            session.getTransaction().commit();
            session.close();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }         
    }

    @Override
    public UserDetails getById(int userId) {
        UserDetails user = null;        
        try {
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();
            user = (UserDetails)session.get(UserDetails.class, userId);        
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
        return user;
    }

    @Override
    public List getAll() {         
        try{       
            session = util.getSessionFactory().openSession();        
            session.beginTransaction();          
            List list = session.createCriteria(UserDetails.class).addOrder(Order.asc("lastName")).list();
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
            Criteria criteria = session.createCriteria(UserDetails.class).setProjection(Projections.max("userId"));
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
            Criteria criteria = session.createCriteria(UserDetails.class);
            Criterion first = Restrictions.like("firstName", "%" + name + "%");
            Criterion second = Restrictions.like("middleName", "%" + name + "%");
            Criterion third = Restrictions.like("lastName", "%" + name + "%");
            Criterion completeCondition = Restrictions.disjunction().add(third)
                    .add(second)
                    .add(third);        
            criteria.add(completeCondition);
            criteria.addOrder(Order.asc("lastName"));
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
