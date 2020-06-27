package com.Model.function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Edgar Liu
 * 在控制器中创建session
 * 网页中得到session
 */
public class SessionProcess {
    HttpServletRequest request;
    HttpServletResponse response;

    public SessionProcess() {
    }

    public SessionProcess(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    //新建session
    public void newSession(String userName, String userType) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);//新建一个session
        session.setAttribute("userType", userType);//新建一个session
        System.out.println(userName + " , " + userType); //test==================
    }


    //移除session
    public void deleteSession() {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        session.removeAttribute("userType");
    }

    //检查是否有session
    public boolean hasSession() throws IOException {
        HttpSession session = request.getSession();
        String sessionUserName = (String) session.getAttribute("userName");
        String sessionUserType = (String) session.getAttribute("userType");
        if (sessionUserName == null || sessionUserType == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getUserName() {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("userName");
    }

    public String getUserType() {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("userType");

    }

}
