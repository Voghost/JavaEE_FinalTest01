package com.Controller;

import com.Model.Entity.*;
import com.Model.function.*;

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
@WebServlet(name = "DeleteEntityServlet",urlPatterns = "/deleteEntityServlet")
public class DeleteEntityServlet extends HttpServlet {
    protected  void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String entityType=request.getParameter("entityType");
        PrintWriter out=response.getWriter();

        //如果是department实体
        if(entityType.equals("department")){
            System.out.println(request.getParameter("deleteSection")); //test==========================
            DepartmentProcess departmentProcess=new DepartmentProcess();
            Department department=new Department(request.getParameter("deleteSection"),null,null);
            departmentProcess.deleteDepartment(department);
            response.sendRedirect("backProcess/departments.jsp");
        }else if(entityType.equals("staff")){
            System.out.println(request.getParameter("deleteSection")); //test==========================
            StaffProcess staffProcess=new StaffProcess();
            Staff staff=new Staff(request.getParameter("deleteSection"),null,null,null,null);
            staffProcess.deleteStaff(staff);
            response.sendRedirect("backProcess/staffs.jsp");
//            out.println("<h1>删除成功, <a  href=\"backProcess/staffs.jsp\" target=\"main\">点击此处返回</a></h1>");
        }else if(entityType.equals("project")){
            System.out.println(request.getParameter("deleteSection")); //test==========================
            ProjectProcess projectProcess=new ProjectProcess();
            Project project=new Project(request.getParameter("deleteSection"),null,null,null);
            projectProcess.deleteProject(project);
            response.sendRedirect("backProcess/projects.jsp");
//            out.println("<h1>删除成功, <a  href=\"backProcess/staffs.jsp\" target=\"main\">点击此处返回</a></h1>");
        }else if(entityType.equals("task")){
            System.out.println(request.getParameter("deleteSection")); //test==========================
            TaskProcess taskProcess=new TaskProcess();
            Task task=new Task(request.getParameter("deleteSection"),null,null,null,null);
            taskProcess.deleteTask(task);
            response.sendRedirect("backProcess/tasks.jsp");
 //           out.println("<h1>删除成功, <a  href=\"backProcess/staffs.jsp\" target=\"main\">点击此处返回</a></h1>");
        }else if(entityType.equals("folder")){
            System.out.println(request.getParameter("deleteSection")); //test==========================
            FolderProcess folderProcess=new FolderProcess();
            Folder folder=new Folder(request.getParameter("deleteSection"),null,null);
            folderProcess.deleteFolder(folder);
            response.sendRedirect("backProcess/folders.jsp");
 //           out.println("<h1>删除成功, <a  href=\"backProcess/staffs.jsp\" target=\"main\">点击此处返回</a></h1>");
        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
