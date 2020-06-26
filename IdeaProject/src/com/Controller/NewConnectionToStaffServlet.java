package com.Controller;

import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Entity.Department;
import com.Model.Entity.Staff;

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
@WebServlet(name = "NewConnectionToStaffServlet",urlPatterns = "/newConnectionToStaffServlet")
public class NewConnectionToStaffServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String entityType=request.getParameter("entityType");
        PrintWriter out=response.getWriter();

        //如果是部门
        if(entityType.equals("department")){
            String []staffIds=request.getParameterValues("staff");
            System.out.println(request.getParameter("sectionDepartment"));
            DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment();
            Staff staff=new Staff();
            Department department=new Department(request.getParameter("sectionDepartment"),null,null);
            System.out.println(department.toString()); //test=============================
            if(staffIds!=null){
                for(int i=0;i<staffIds.length;i++){
                    staff.setStaffId(staffIds[i]);
                    databaseStaffDepartment.connectStaffToDepartment(staff,department);
                }
            }
            response.sendRedirect("backProcess/departments.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
