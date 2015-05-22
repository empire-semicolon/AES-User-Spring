/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.dao;

import com.aes.model.BusinessUnit;
import java.util.List;

/**
 *
 * @author Bryan
 */
public interface BusinessUnitDao {
    
    public void add(BusinessUnit businessUnit);
    public void edit(BusinessUnit businessUnit);
    public void delete(int businessUnitId);
    public BusinessUnit getById(int businessUnitId);
    public List getAll();
    public int getNextId();
    public List searchName(String name);
    
}
