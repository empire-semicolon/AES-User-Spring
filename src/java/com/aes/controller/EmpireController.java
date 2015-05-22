/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.controller;

import com.aes.model.BusinessUnit;
import com.aes.service.EmpireService;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Bryan
 */

@Controller
@RequestMapping("/admin")
public class EmpireController {
    
    @Autowired
    private EmpireService service;
    
    @RequestMapping(value="/bu")
    public String setupForm(Map<String, Object> map){
        BusinessUnit record = new BusinessUnit();
        map.put("bu", record);
        map.put("bus", (List<BusinessUnit>)service.getAllBusinessUnit());
        return "ambot_lang";
    }
    
    @RequestMapping(value="/budo", method=RequestMethod.POST)
    public String doActions(@ModelAttribute BusinessUnit student, BindingResult result, @RequestParam String action, Map<String, Object> map){
        BusinessUnit studentResult = new BusinessUnit();
        switch(action.toLowerCase()){	
        case "add":
                service.addBusinessUnit(student);
                studentResult = student;
                break;
        case "edit":
                service.updateBusinessUnit(student);
                studentResult = student;
                break;
        case "delete":
                service.deleteBusinessUnit(student.getBusinessUnitId());
                studentResult = new BusinessUnit();
                break;
        case "search":
                BusinessUnit searchedStudent = service.getBusinessUnit(student.getBusinessUnitId());
                studentResult = searchedStudent!=null ? searchedStudent : new BusinessUnit();
                break;
        }
        map.put("bu", studentResult);
        map.put("bus", service.getAllBusinessUnit());
        return "ambot_lang";
    }
    
    
    
}
