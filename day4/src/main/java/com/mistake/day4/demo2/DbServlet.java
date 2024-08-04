package com.mistake.day4.demo2;


import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class DbServlet extends HttpServlet implements Servlet {
    private static final long serialVersionUID = 1L;

    public DbServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset =utf-8");
        String strSql = request.getParameter("strsql");
        DbProc obj = new DbProc();
        try {
            obj.connect();
            obj.executeUpdate(strSql);
            obj.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
