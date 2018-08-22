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
import java.util.List;

@WebServlet(value = "/book/bookFind")
public class BookFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        BookDao bookDao = new BookMemoryDao();
        List<Book> books = bookDao.getBookByName(name);
        req.setAttribute("bookList", books);
        req.getSession().setAttribute("msg","查询条件是"+name);
        req.getRequestDispatcher("/jsp/book_list.jsp").forward(req, resp);
    }
}
