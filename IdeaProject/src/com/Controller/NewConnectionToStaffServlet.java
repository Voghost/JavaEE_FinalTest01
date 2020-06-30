package com.Controller;

import com.Model.Database.DatabaseStaffDepartment;
import com.Model.Database.DatabaseStaffProject;
import com.Model.Database.DatabaseStaffTask;
import com.Model.Entity.Department;
import com.Model.Entity.Project;
import com.Model.Entity.Staff;
import com.Model.Entity.Task;

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
            //如果是任务
        }else if(entityType.equals("task")){
            String []staffIds=request.getParameterValues("staff");
            DatabaseStaffTask databaseStaffTask=new DatabaseStaffTask();
            Staff staff=new Staff();
            Task task=new Task(request.getParameter("sectionTask"),null,null,null,null);
            if(staffIds!=null){
                for(int i=0;i<staffIds.length;i++){
                    staff.setStaffId(staffIds[i]);
                    databaseStaffTask.connectStaffToTask(staff,task);
                }
            }
            response.sendRedirect("backProcess/tasks.jsp");
            //如果是项目
        }else if(entityType.equals("project")){
            String []staffIds=request.getParameterValues("staff");
            DatabaseStaffProject databaseStaffProject=new DatabaseStaffProject();
            Staff staff=new Staff();
            Project project=new Project(request.getParameter("sectionProject"),null,null,null);
            System.out.println(project.toString()); //test=============================
            if(staffIds!=null){
                for(int i=0;i<staffIds.length;i++){
                    staff.setStaffId(staffIds[i]);
                    databaseStaffProject.connectStaffToProject(staff,project);
                }
            }
            response.sendRedirect("backProcess/projects.jsp");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
