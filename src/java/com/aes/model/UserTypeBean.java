/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.model;

/**
 *
 * @author Bryan
 */
public class UserTypeBean {
    
    public int intUserTypeId;
    public String strUserType;

    public int getIntUserTypeId() {
        return intUserTypeId;
    }

    public void setIntUserTypeId(int intUserTypeId) {
        this.intUserTypeId = intUserTypeId;
    }

    public String getStrUserType() {
        return strUserType;
    }

    public void setStrUserType(String strUserType) {
        this.strUserType = strUserType;
    }

    @Override
    public String toString() {
        return "UserTypeBean{" + "intUserTypeId=" + intUserTypeId + ", strUserType=" + strUserType + '}';
    }
    
}
