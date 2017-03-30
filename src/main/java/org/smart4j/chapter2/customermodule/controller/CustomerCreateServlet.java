package org.smart4j.chapter2.customermodule.controller;

import org.apache.commons.lang3.StringUtils;
import org.smart4j.chapter2.basicmodule.model.Message;
import org.smart4j.chapter2.customermodule.service.CustomerService;
import org.smart4j.chapter2.basicmodule.util.CollectionUtil;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建客户
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet {
    CustomerService customerService;
    @Override
    public void init() throws ServletException {
        customerService =new CustomerService();
    }

    /**
     * 进入 创建客户 界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/customer_create.jsp").forward(req,resp);
    }

    /**
     * 处理 创建客户 请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map=new HashMap<String,Object>();
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name") ;//客户姓名
        String contact = req.getParameter("contact");//联系人
        String telephone = req.getParameter("telephone");//电话号码
        String email = req.getParameter("email");//邮箱
        String remark = req.getParameter("remark");//备注
        StringBuffer error_info=new StringBuffer();
        if (StringUtils.isNotBlank(name) && !"null".equals(name.toLowerCase())){
            map.put("name",name);
        }else {
            error_info.append("客户姓名不能为空");
        }
        if (StringUtils.isNotBlank(contact)&&!"null".equals(contact.toLowerCase())){
            map.put("contact",contact);
        }else {
            if (error_info.length()>0){
                error_info.append("、联系人不能为空");
            }else{
                error_info.append("联系人不能为空");
            }
        }
        if (StringUtils.isNotBlank(telephone)&&!"null".equals(telephone.toLowerCase())){
            map.put("telephone",telephone);
        }else {
            if (error_info.length()>0){
                error_info.append("、电话不能为空");
            }else{
                error_info.append("电话不能为空");
            }
        }
        if (StringUtils.isNotBlank(email)&&!"null".equals(email.toLowerCase())){
            map.put("email",email);
        }else {
            if (error_info.length()>0){
                error_info.append("、邮箱不能为空");
            }else{
                error_info.append("邮箱不能为空");
            }
        }
        if (StringUtils.isNotBlank(remark)&& !"null".equals(remark.toLowerCase())){
            map.put("remark",remark);
        }
        Boolean flag=Boolean.FALSE;
        Message msg=new Message();
        if(error_info.length()>0){
            msg.setInfo(error_info.toString());
            msg.setSuccess(Boolean.FALSE);
            req.getRequestDispatcher("/WEB-INF/view/customer_new.jsp").forward(req,resp);
        }
        if (CollectionUtil.isNotEmpty(map)){
            flag= customerService.createCustomer(map);
        }else {
            msg.setInfo("新增的信息不能为空！");
            msg.setSuccess(Boolean.FALSE);
        }
        if(flag){
            msg.setSuccess(Boolean.TRUE);
            msg.setInfo("新增成功！");
            req.setAttribute("msg",msg);
            resp.sendRedirect(req.getContextPath() +"/customer");//跳转list页面
        }else{
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/WEB-INF/view/customer_create.jsp").forward(req,resp);
        }
    }
}
