package com.web;

import com.dao.BookDao;
import com.dao.BookMemoryDao;
import com.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book/addBook")
public class BookAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/book_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        Float price= Float.valueOf(req.getParameter("price"));
        String writter=req.getParameter("writter");
        BookDao bookDao=new BookMemoryDao();
        bookDao.addBook(new Book(id,name,price,writter));
        resp.sendRedirect("/book/index");
    }
}
