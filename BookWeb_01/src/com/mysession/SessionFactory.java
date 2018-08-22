package com.mysession;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionFactory {
    //为每个session设置一个独立的ID
    private final static String SESSION_KEY = "MY_SID";
    //静态变量存储session，只要连接一直存在它就一直存在
    private static Map<String, MySession> sessionMap = new HashMap<String, MySession>();

    //获得session对象
    public static MySession getSession(HttpServletRequest req, HttpServletResponse rsp) {
        //session的Id
        String sid = null;
        MySession session = null;

        //从cookie中获得session的Id
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SESSION_KEY)) {
                    sid = cookie.getValue();
                    break;
                }
            }
        }

        //如果session不存在，证明是第一次访问，这时就需要初始化session
        if(checkSessionId(sid)){
            sid=generateSessionId();//设置一个随机的session的Id
            session=createSession(sid);//添加一个新的seesion
            // 在响应的时候，让浏览器在 cookie 里保存生成的 sid
            // 那么浏览器在下次请求的时候，会自动将这些 cookie 信息发送到服务器
            rsp.addCookie(new Cookie(SESSION_KEY,sid));
        }else{
            //如果可从cookie里获取到sid
            //冲sessionMap里面获得session对象
            session=sessionMap.get(sid);
            if(session==null){
                //如果这个对象为空，重新创建
                session=createSession(sid);
            }
        }


        return session;
    }


    /**
     * 检查sid是否为空
     *
     * @param sid
     * @return boolean
     */
    private static boolean checkSessionId(String sid) {
        if (sid == null || sid.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成sessionId，
     *
     * @return 全球唯一标识字符串sessionId
     */
    private static String generateSessionId() {
        return String.valueOf(UUID.randomUUID());
    }


    private static MySession createSession(String sid) {
        MySession session = new MemorySession(sid);
        sessionMap.put(sid,session);
        return session;
    }
}
