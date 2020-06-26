package com.Controller;

import com.Model.Entity.Department;
import com.Model.function.DepartmentProcess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Edgar Liu
 */
@WebServlet(name = "NewEntityServlet" ,urlPatterns = "/newEntityServlet")
public class NewEntityServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String entityType=request.getParameter("entityType");
        PrintWriter out=response.getWriter();


        //如果是上传了department对象
        if(entityType.equals("department")){
            DepartmentProcess departmentProcess=new DepartmentProcess();
            Department department=new Department(null,request.getParameter("departmentName"),request.getParameter("departmentAddress"));
            departmentProcess.newDepartment(department);
            out.println("添加成功");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
