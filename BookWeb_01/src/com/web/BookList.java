package com.web;

import com.dao.BookDao;
import com.dao.BookMemoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BookList extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDao bookDao = new BookMemoryDao();
        req.setAttribute("bookList",bookDao.getAll());
        HttpSession session=req.getSession();
        req.getRequestDispatcher("/jsp/book_list.jsp").forward(req,resp);
    }
}
