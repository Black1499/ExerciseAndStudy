package com.web;

import com.dao.BookDao;
import com.dao.BookMemoryDao;
import com.entity.Book;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/BookById")
public class BookById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        BookDao bookDao=new BookMemoryDao();
        Book book = bookDao.getBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/jsp/book_info.jsp").forward(req,resp);
    }
}
