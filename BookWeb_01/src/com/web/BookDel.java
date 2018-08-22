package com.web;

import com.dao.BookDao;
import com.dao.BookMemoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book/delBook")
public class BookDel extends HttpServlet {
    private BookDao bookDao = new BookMemoryDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        bookDao.dleBook(id);
        req.getSession().setAttribute("msg", "删除成功。");
        resp.sendRedirect("/book/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] checks=req.getParameterValues("check");
        for (String check : checks) {
            bookDao.dleBook(Integer.parseInt(check));
        }
        req.getSession().setAttribute("msg", "删除成功。");
        resp.sendRedirect("/book/index");
    }
}
