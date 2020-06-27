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
import java.text.SimpleDateFormat;
import java.util.Date;

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
            response.sendRedirect("backProcess/departments.jsp");
            //            out.println("添加成功");
        }else if(entityType.equals("staff")){
            StaffProcess staffProcess=new StaffProcess();
            Staff staff=new Staff(null,request.getParameter("staffName"),request.getParameter("staffPhone"),null,request.getParameter("staffPassword"));
            staffProcess.newStaff(staff);
            response.sendRedirect("backProcess/staffs.jsp");
            //           out.println("添加成功");
        }else if(entityType.equals("project")){
            ProjectProcess projectProcess=new ProjectProcess();
            /**
             * 文件ID暂时为null 功能稍后完善
             */
            Project project=new Project(null,request.getParameter("ProjectName"),null,request.getParameter("ProjectRemark"));
            projectProcess.newProject(project);
            response.sendRedirect("backProcess/projects.jsp");
            //           out.println("添加成功");
        }else if(entityType.equals("folder")){
            FolderProcess folderProcess=new FolderProcess();
            /**
             * 文件ID暂时为null 功能稍后完善
             */
            Folder folder=new Folder(null,request.getParameter("FolderPath"),request.getParameter("FolderRemark"));
            folderProcess.newFolder(folder);
            response.sendRedirect("backProcess/folders.jsp");
            //          out.println("添加成功");
        }else if(entityType.equals("task")){
            TaskProcess taskProcess=new TaskProcess();
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            String nowDate=df.format(new Date());
            Task task=new Task(null,request.getParameter("TaskName"),request.getParameter("TaskRemark"),nowDate,request.getParameter("TaskEndDate"));
            System.out.println(task.toString());//==============test
            taskProcess.newTask(task);
            response.sendRedirect("backProcess/tasks.jsp");
//            out.println("添加成功");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
