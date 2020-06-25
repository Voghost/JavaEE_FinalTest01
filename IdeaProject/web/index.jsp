<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Model.Entity.*" %>
<%@ page import="com.Model.Database.*" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/22
  Time: 下午8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    /*Staff staff = new Staff("S00001", "员工1", null, null, null);
    DatabaseStaff databaseStaff = new DatabaseStaff();
    //databaseStaff.insertStaff(staff);

    ArrayList<Staff> staffs = databaseStaff.searchStaff(staff);
    System.out.println(staffs.size());
    for (int i = 0; i < staffs.size(); i++) {
        System.out.println("staffId: " + staffs.get(i).getStaffId() + ", StaffName: " + staffs.get(i).getStaffName());
    }*/

    //Task task =new Task("T00000002","task","无","2020-01-01","2020-02-02");
    //DatabaseTask databaseTask=new DatabaseTask();
    //databaseTask.insertTask(task);
    //databaseTask.updateTask(task);
    //databaseTask.deleteTask(task);
    /*ArrayList<Task> tasks = databaseTask.searchTask("task",2);
    for (int i = 0; i < tasks.size(); i++) {
        System.out.println("TaskId: " + tasks.get(i).getTaskId() + ", TaskName: " + tasks.get(i).getTaskName());
    }
    ArrayList<Task> tasks = databaseTask.searchTask(task);
    for (int i = 0; i < tasks.size(); i++) {
        System.out.println("TaskId: " + tasks.get(i).getTaskId() + ", TaskName: " + tasks.get(i).getTaskName());
    }*/

    /*Project project = new Project("P00000001", "project1", null, null);
    DatabaseProject databaseProject = new DatabaseProject();
    ArrayList<Project> projects = databaseProject.searchProject(project);
    System.out.println(projects.size());
    for (int i = 0; i < projects.size(); i++) {
        System.out.println("projectId: " + projects.get(i).getProjectId() + ", projectName: " + projects.get(i).getProjectName());
    }*/

    /*Folder folder = new Folder("F00000001", "root", "五");
    DatabaseFolder databaseFolder = new DatabaseFolder();
    //databaseFolder.insertFolder(folder);
    //databaseFolder.updateFolder(folder);
    //databaseFolder.deleteFolder(folder);
    ArrayList<Folder> folders = databaseFolder.searchFolder("root",2);
    for (int i = 0; i < folders.size(); i++) {
        System.out.println("folderId: " + folders.get(i).getFolderId() + ", folderPath: " + folders.get(i).getFolderPath());
    }*/
    /*Staff staff=new Staff(null,null,null,null,null);
    Department department=new Department("D002",null,null);

    DatabaseStaffDepartment databaseStaffDepartment=new DatabaseStaffDepartment();
    //databaseStaffDepartment.connectStaffToDepartment(staff,department);
    //databaseStaffDepartment.deleteStaffToDepartment(staff,department);

    ArrayList<StaffDepartment> staffDepartments=databaseStaffDepartment.searchStaffOrDepartment(staff,department);
    for (int i = 0; i < staffDepartments.size(); i++) {
        System.out.println("StaffId="+staffDepartments.get(i).getStaffId()+", DepartmentId+"+staffDepartments.get(i).getDepartmentId());
    }*/

    Staff staff=new Staff("S00001","员工1","23423423",null,"234234");
    Project project=new Project("P00000005",null,null,null);
    DatabaseStaffProject databaseStaffProject=new DatabaseStaffProject();
    //databaseStaffProject.connectStaffToProject(staff,project);
    databaseStaffProject.deleteStaffToProject(staff,project);
    /*ArrayList<StaffProject> staffProjects=databaseStaffProject.searchStaffOrProject(staff,project);
    for(int i=0;i<staffProjects.size();i++){
        System.out.println("StaffId="+staffProjects.get(i).getStaffId()+",ProjectId+"+staffProjects.get(i).getProjectId());
    }*/
%>
</body>
</html>
