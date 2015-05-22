/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.service;

import com.aes.dao.impl.BusinessUnitDaoImpl;
import com.aes.model.BusinessUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bryan
 */
@Service
public class EmpireService {    
    
    @Autowired
    private BusinessUnitDaoImpl businessUnitService;
    
    @Transactional
    public void addBusinessUnit (BusinessUnit businessUnit){
        businessUnitService.add(businessUnit);
    }
    
    @Transactional
    public void updateBusinessUnit (BusinessUnit businessUnit){
        businessUnitService.edit(businessUnit);
    }
    
    @Transactional
    public void deleteBusinessUnit (int id){
        businessUnitService.delete(id);
    }
    
    @Transactional
    public List getAllBusinessUnit (){
        return businessUnitService.getAll();
    }
    
    @Transactional
    public List searchBusinessUnit(String name){
        return businessUnitService.searchName(name);
    }
    
    @Transactional
    public BusinessUnit getBusinessUnit(int businessUnitId){
        return businessUnitService.getById(businessUnitId);
    }    
    
    
}
