package com.Controller;

import com.Model.Database.DatabaseDepartment;
import com.Model.Database.DatabaseStaff;
import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Entity.Department;
import com.Model.Entity.Staff;
import com.Model.function.DetermineAccount;
import com.Model.function.SessionProcess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Edgar Liu
 * 控制登陆的选项
 */
@WebServlet(name = "LoginHandlerServlet",urlPatterns = {"/loginHandlerServlet"})
public class LoginHandlerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher=null;

        int judgeAccount=0;// 判断用户的合法性

        Staff staff =new Staff(request.getParameter("userName"),null,null,null,request.getParameter("password"));
        DetermineAccount determineAccount=new DetermineAccount(staff);
        judgeAccount=determineAccount.determine();

        //如果密码正确，导向loginSuccessFull.jsp
        if(judgeAccount==2){
            DatabaseStaffDepartment databaseDepartment=new DatabaseStaffDepartment();

            SessionProcess sessionProcess=new SessionProcess(request,response);
            //如果是管理部门
            if(databaseDepartment.isManagerDepartment(staff)){
                sessionProcess.newSession(staff.getStaffId(),"manager");
            }else{
                //普通员工
                sessionProcess.newSession(staff.getStaffId(),"staff");
            }
            dispatcher=request.getRequestDispatcher("loginSuccessful.jsp");
            dispatcher.forward(request,response);
        }else if(judgeAccount<2&&judgeAccount>=0){
            //否重新导向登陆界面
            dispatcher=request.getRequestDispatcher("login.jsp");
            request.setAttribute("error","用户名或密码错误");
            dispatcher.forward(request,response);
        }else {
            response.sendRedirect("error.jsp");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
