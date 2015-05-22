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
 * CourseCategory generated by hbm2java
 */
@Entity
@Table(name="course_category"
    ,catalog="aes"
)
public class CourseCategory  implements java.io.Serializable {


     private int courseCategoryId;
     private String courseCategory;
     private Set<Course> courses = new HashSet<Course>(0);

    public CourseCategory() {
    }

	
    public CourseCategory(int courseCategoryId, String courseCategory) {
        this.courseCategoryId = courseCategoryId;
        this.courseCategory = courseCategory;
    }
    public CourseCategory(int courseCategoryId, String courseCategory, Set<Course> courses) {
       this.courseCategoryId = courseCategoryId;
       this.courseCategory = courseCategory;
       this.courses = courses;
    }
   
     @Id 

    
    @Column(name="courseCategoryId", unique=true, nullable=false)
    public int getCourseCategoryId() {
        return this.courseCategoryId;
    }
    
    public void setCourseCategoryId(int courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    
    @Column(name="courseCategory", nullable=false, length=45)
    public String getCourseCategory() {
        return this.courseCategory;
    }
    
    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="courseCategory")
    public Set<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }




}


