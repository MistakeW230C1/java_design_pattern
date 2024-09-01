package com.mistake.day6.demo7;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SalaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SalaryServlet(){

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=");
        String emno = req.getParameter("emno");
        int type = Integer.parseInt( req.getParameter("type"));
        IPara iPara = new SalaryPara();
        AbstractShow show = null;
        switch (type){
            case 1:
                show = new TableShow();
                break;
            case 2:
                show = new GraphShow();
                break;
        }
        show.setPara(iPara);
        AbstractThing abstractThing = new Employee(show);

        String s = "";
        try{
            s = abstractThing.show(emno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().print(s);
    }

}
