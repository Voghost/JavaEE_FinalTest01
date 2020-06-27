package com.Controller;

import com.Model.Entity.Staff;
import com.Model.function.DetermineAccount;
import com.Model.function.StaffProcess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

/**
 * Created by Edgar Liu
 */
@WebServlet(name = "RegisterHandlerServlet",urlPatterns = "/registerHandlerServlet")
public class RegisterHandlerServlet extends HttpServlet {
   protected  void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
       request.setCharacterEncoding("utf-8");
       RequestDispatcher dispatcher=null;

       int judgeAccount=0;// 判断用户的合法性

       Staff staff =new Staff(null,request.getParameter("name"),request.getParameter("phone"),null,request.getParameter("password"));
       DetermineAccount determineAccount=new DetermineAccount(staff);
       judgeAccount=determineAccount.determine();

       //如果存在用户名
       if(judgeAccount>0){
           dispatcher=request.getRequestDispatcher("login.jsp");
           request.setAttribute("message","用户名已存在");
           dispatcher.forward(request,response);
       }
       else if(judgeAccount==0){
           StaffProcess staffProcess=new StaffProcess();
           String newUserName= staffProcess.newStaff(staff);
           dispatcher=request.getRequestDispatcher("login.jsp");
           request.setAttribute("message","注册成功, 你的账号是: "+newUserName);
           dispatcher.forward(request,response);
       }else  {
           dispatcher=request.getRequestDispatcher("error.jsp");
           request.setAttribute("message","有错误J");
           dispatcher.forward(request,response);
       }
   }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
