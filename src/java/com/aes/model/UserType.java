package com.aes.model;
// Generated May 22, 2015 8:39:55 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserType generated by hbm2java
 */
@Entity
@Table(name="user_type"
    ,catalog="aes"
)
public class UserType  implements java.io.Serializable {


     private int userTypeId;
     private String userType;
     private Set<UserDetails> userDetailses = new HashSet<UserDetails>(0);

    public UserType() {
    }

	
    public UserType(int userTypeId, String userType) {
        this.userTypeId = userTypeId;
        this.userType = userType;
    }
    public UserType(int userTypeId, String userType, Set<UserDetails> userDetailses) {
       this.userTypeId = userTypeId;
       this.userType = userType;
       this.userDetailses = userDetailses;
    }
   
     @Id 

    
    @Column(name="userTypeId", unique=true, nullable=false)
    public int getUserTypeId() {
        return this.userTypeId;
    }
    
    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    
    @Column(name="userType", nullable=false, length=45)
    public String getUserType() {
        return this.userType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="userType")
    public Set<UserDetails> getUserDetailses() {
        return this.userDetailses;
    }
    
    public void setUserDetailses(Set<UserDetails> userDetailses) {
        this.userDetailses = userDetailses;
    }




}


