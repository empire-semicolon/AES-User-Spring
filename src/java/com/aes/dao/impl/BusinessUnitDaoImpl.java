/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao.impl;

import com.aes.dao.BusinessUnitDao;
import com.aes.model.BusinessUnit;
import com.aes.model.UserDetails;
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
public class BusinessUnitDaoImpl implements BusinessUnitDao {        
    
    @Autowired
    private SessionFactory session;   
    
    @Override
    public void add(BusinessUnit businessUnit) {
        session.getCurrentSession().save(businessUnit);
    }

    @Override
    public void edit(BusinessUnit businessUnit) {
        session.getCurrentSession().update(businessUnit);
    }

    @Override
    public void delete(int businessUnitId) {
        session.getCurrentSession().delete(getById(businessUnitId));
    }

    @Override
    public BusinessUnit getById(int businessUnitId) {
        return (BusinessUnit)session.getCurrentSession()
                .get(BusinessUnit.class, businessUnitId);
    }

    @Override
    public List getAll() {        
        return session.getCurrentSession().createCriteria(BusinessUnit.class)
                .addOrder(Order.asc("businessUnitId")).list();
    }

    @Override
    public int getNextId() {              
        int max = (int)session.getCurrentSession().createCriteria(BusinessUnit.class)
                .setProjection(Projections.max("businessUnitId")).uniqueResult();
        return max+1;
    }

    @Override
    public List searchName(String name) {
        Criteria criteria = session.getCurrentSession().createCriteria(BusinessUnit.class);
        Criterion condition = Restrictions.like("businessUnit", "%" + name + "%");
        criteria.add(condition);
        return criteria.list();        
    }
    
}
