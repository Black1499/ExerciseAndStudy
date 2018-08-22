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

@WebServlet(value = "/book/updBook")
public class BookUpd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        BookDao bookDao =  new BookMemoryDao();
        Book book=bookDao.getBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/jsp/book_form_upd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        Float price= Float.valueOf(req.getParameter("price"));
        String writter=req.getParameter("writter");
        BookDao bookDao=new BookMemoryDao();
        bookDao.updBook(new Book(id,name,price,writter));
        req.getSession().setAttribute("msg","更新成功");
        resp.sendRedirect("/book/BookById?id="+id);
    }

}
