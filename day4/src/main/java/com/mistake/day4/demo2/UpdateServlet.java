package com.mistake.day4.demo2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset =utf-8");
        request.getSession().setAttribute("user", "1");
        int type = Integer.parseInt(request.getParameter("mytype"));
        String account = request.getParameter("user");
        IWebBuilder obj = null;
        switch (type) {
            case 1:
                obj = new StudentWebBuild();
                break;
            case 2:
                obj = new TeacherWebBuild();
                break;
        }
        Director director = new Director(obj);
        String s = director.build(account);
        s += "<input type = 'hidden' id ='account' value = '" + account + "'/>";
        PrintWriter out = response.getWriter();
        out.println(s);
    }
}
