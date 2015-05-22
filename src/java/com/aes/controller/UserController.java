/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aes.controller;

import com.aes.dao.UserDao;
import com.aes.model.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Author:          Mark
 * Date created:    May 16, 2015
 * Time created:    9:49:03 AM
 */
public class UserController extends HttpServlet {
	
		private static final String index = "/pages/index.jsp";
    /**
     * MY COURSES
     */
    private static final String courseOutline = "/pages/course_outline.jsp";
    private static final String examsByCourse = "/pages/course_exams.jsp";
    private static final String pastCourses = "/pages/past_courses.jsp";
    private static final String course = "/pages/course.jsp";
    /**
     * MY EXAMS
     */
    private static final String upcomingExams = "/pages/user/exam/upcoming_exams.jsp";
    private static final String pastExams = "/pages/user/exam/past_exams.jsp";
    private static final String exam = "/pages/exam.jsp";
    /**
     * MY PROFILE
     */
    private static final String viewProfile = "/pages/user/profile/view_profile.jsp";
    private static final String editProfile = "/pages/user/profile/edit_profile.jsp";
    private static final String changePassword = "/pages/user/profile/change_password.jsp";
		
		private final int userId = 20151234; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserBean user = new UserBean();
				user.setIntUserId(userId);
				
        String forward = index;
				String action = "";
        //int accountID = (int)session.getAttribute("accountID");
				if(request.getParameter("page") != null){
					action = request.getParameter("page");
				}

				System.out.println("doGet");
				
        /**
         * MY COURSES
         */
        if (action.equals("courseOutline")) {
            //get course outline by courseID
            request.setAttribute("course_outline", courseOutline);
            forward = courseOutline;
        }// else if (action.equals("examsByCourse")) {
//            //get exams by courseID
//            request.setAttribute("exams", exams);
//            forward = examsByCourse;
//        } else if (action.equals("pastCourses")) {
//            //get past courses by accountID
//            request.setAttribute("courses", courses);
//            forward = pastCourses;
//        } else if (action.equals("viewCourse")) {
//            int courseID = Integer.parseInt(request.getParameter("courseID"));
//            CourseBean course = SystemDao.getCourseByID(courseID);
//            request.setAttribute("course", course);
//            forward = course;
//        } /**
//         * MY EXAMS
//         */
//        else if (action.equals("upcomingExams") || action.equals("pastExams")) {
//            //get exams by accountID
//            request.setAttribute("exams", exams);
//            if (action.equals("upcomingExams")) {
//                forward = upcomingExams;
//            } else if (action.equals(pastExams)
//    		 {
//                forward = pastExams;
//            }
//        } else if (action.equals("takeExam") || action.equals("viewExam")) {
//            int examID = Integer.parseInt(request.getParameter("examID"));
//            ExamBean exam = SystemDao.getExamByID(examID);
//            request.setAttribute("exam", exam);
//            forward = exam;
//        } /**
//         * MY PROFILE
//         */
        else if (action.equals("viewProfile") || action.equals("editProfile")
                || action.equals("changePassword")) {
            UserBean account = UserDao.getUserById(userId);
            request.setAttribute("account", account);
            if (action.equals("viewProfile")) {
                forward = viewProfile;
            } else if (action.equals("editProfile")) {
                forward = editProfile;
            } else if (action.equals("changePassword")) {
                forward = changePassword;
            }
        } //else if (action.equals("submitEditProfile")) {
//            //update profile by accountID
//            forward = editProfile;
//        } else if (action.equals("submitChangePassword")) {
//            //update password by accountID
//            forward = changePassword;
//        }
//
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserBean user = new UserBean();
                user.setIntUserId(userId);
                
        String forward = "";
        //int accountID = (int)session.getAttribute("accountID");
        String action = request.getParameter("page");

				System.out.println("doPost");
				
        /**
         * MY COURSES
         */
        if (action.equals("courseOutline")) {
            //get course outline by courseID
            request.setAttribute("course_outline", courseOutline);
            forward = courseOutline;
        }// else if (action.equals("examsByCourse")) {
//            //get exams by courseID
//            request.setAttribute("exams", exams);
//            forward = examsByCourse;
//        } else if (action.equals("pastCourses")) {
//            //get past courses by accountID
//            request.setAttribute("courses", courses);
//            forward = pastCourses;
//        } else if (action.equals("viewCourse")) {
//            int courseID = Integer.parseInt(request.getParameter("courseID"));
//            CourseBean course = SystemDao.getCourseByID(courseID);
//            request.setAttribute("course", course);
//            forward = course;
//        } /**
//         * MY EXAMS
//         */
       else if (action.equals("upcomingExams") || action.equals("pastExams")) {
           //get exams by accountID
           /*request.setAttribute("exams", exams);*/
           if (action.equals("upcomingExams")) {
               forward = upcomingExams;
           } else if (action.equals(pastExams))
          {
               forward = pastExams;
           }
       } else if (action.equals("takeExam") || action.equals("viewExam")) {
           /*int examID = Integer.parseInt(request.getParameter("examID"));
           ExamBean exam = SystemDao.getExamByID(examID);
           request.setAttribute("exam", exam);*/
           forward = exam;
       } /**
        * MY PROFILE
        */
        else if (action.equals("viewProfile") || action.equals("editProfile")
                || action.equals("changePassword")) {
            UserBean account = UserDao.getUserById(20151234);
            request.setAttribute("account", account);
            if (action.equals("viewProfile")) {
                System.out.println("View Profile Accessed");
                forward = viewProfile;
            } else if (action.equals("editProfile")) {
                forward = editProfile;
            } else if (action.equals("changePassword")) {
                forward = changePassword;
            }
        } //else if (action.equals("submitEditProfile")) {
//            //update profile by accountID
//            forward = editProfile;
//        } else if (action.equals("submitChangePassword")) {
//            //update password by accountID
//            forward = changePassword;
//        }
//
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }
}
