package com.test;

import com.mysession.MySession;
import com.mysession.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/test_02")
public class TestServletTwo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MySession session = SessionFactory.getSession(req, resp);
        resp.getWriter().print(session.get("msg"));
    }
}
