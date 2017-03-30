package org.smart4j.chapter2.customermodule.controller;

import org.smart4j.chapter2.basicmodule.model.Message;
import org.smart4j.chapter2.customermodule.service.CustomerService;
import org.smart4j.chapter2.basicmodule.util.CastUtil;
import org.smart4j.chapter2.basicmodule.util.StringUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除客户
 */
@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {
    CustomerService customerService;
    Message msg;

    @Override
    public void init() throws ServletException {
        customerService =new CustomerService();
        msg=new Message();

    }
    /**
     * 处理 删除客户 请求
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO
        String id = req.getParameter("id");
        if(StringUtil.isNotEmpty(id)){
            boolean flag = customerService.deleteCustomer(CastUtil.castLong(id));

            if(flag){
                msg.setInfo("删除成功！");
                msg.setSuccess(Boolean.TRUE);
            }else{
                msg.setInfo("删除失败！");
                msg.setSuccess(Boolean.FALSE);
            }
            req.setAttribute("",msg);
            resp.sendRedirect(req.getContextPath()+"/customer");
        }else{
            req.getRequestDispatcher("/customer").forward(req,resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDelete(req,resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDelete(req,resp);
    }
}
