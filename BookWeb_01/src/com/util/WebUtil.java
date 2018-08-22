package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebUtil {
    public static String getSessionValue(HttpServletRequest req){
        HttpSession session=req.getSession();
        String msg= (String) session.getAttribute("msg");

        if( msg!=null && ! msg.isEmpty()){
            return "<div class='alert alert-primary'>"+msg+"</div>";
        }
        session.setAttribute("msg","");
        return "";
    }
}
