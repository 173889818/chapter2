package org.smart4j.chapter2.systemodule.userController;

import org.smart4j.chapter2.systemodule.UserModel.User;
import org.smart4j.chapter2.systemodule.UserService.UserService;
import org.smart4j.chapter2.basicmodule.model.Message;
import org.smart4j.chapter2.basicmodule.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;

/**
 * Created by dingcc on 2017/3/27.
 */
/**
 * 用户登录
 */
@WebServlet("/user_login")
public class UserController extends HttpServlet {
    UserService UserService;
    @Override
    public void init() throws ServletException {
        UserService =new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
        Map<String, Cookie> cookieMap = ReadCookieMap(req);
            if (null!=cookieMap&&cookieMap.size()>2){
                Iterator<String> iterator = cookieMap.keySet().iterator();
//                JSESSIONID
                while (iterator.hasNext()){
                    Cookie cookie = cookieMap.get(iterator.next());
                    String name = cookie.getName();
                    if(!"JSESSIONID".equals(cookie.getName().toUpperCase())){
                        String decode = URLDecoder.decode(cookie.getValue(),"utf-8");
                        String value = cookie.getValue();
                        System.out.print("name:"+name+"value:"+value+"decode:"+decode);
                    }
                }
            resp.sendRedirect(req.getContextPath() +"/customer");//跳转list页面
        }else{
            System.out.print("null");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User();
        Message msg=new Message();
        if (StringUtil.isNotEmpty(userName)&&!"null".equals(userName)){
            user.setUsername(userName);
        }else {
            msg.setSuccess(Boolean.FALSE);
            msg.setInfo("请输入登录名！");
        }
        if (StringUtil.isNotEmpty(password)&&!"null".equals(password)){
            user.setPassword(password);
        }else {
            msg.setSuccess(Boolean.FALSE);
            msg.setInfo("请输入密码！");
        }
        Boolean LogSign =Boolean.FALSE;
        if (msg.getSuccess()){
           LogSign = UserService.getUser(user);

        }
        if(LogSign){
            req.setAttribute("msg",msg);
            setCookie(resp,userName.trim(),password.trim(),-1);
            resp.sendRedirect(req.getContextPath() +"/customer");//跳转list页面
        }else {
            msg.setSuccess(Boolean.FALSE);
            msg.setInfo("用户名或密码错误！");
            req.setAttribute("msg",msg);
            resp.sendRedirect(req.getContextPath() +"/user_login");
        }
    }

   /* *//**
     * 根据名字获取cookie
     *
     * @param response
     * @param name
     *            cookie名字
     * @return
     */
    public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value,Integer time) {
        // new一个Cookie对象,键值对为参数
        Cookie cookie = new Cookie(name, value);
        // tomcat下多应用共享
        cookie.setPath("/");
        // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(time);
        // 将Cookie添加到Response中,使之生效
        response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        return response;
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name
     *            cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, HttpServletResponse name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }
}
