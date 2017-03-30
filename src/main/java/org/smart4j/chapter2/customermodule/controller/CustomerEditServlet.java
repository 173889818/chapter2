package org.smart4j.chapter2.customermodule.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart4j.chapter2.customermodule.model.Customer;
import org.smart4j.chapter2.customermodule.service.CustomerService;
import org.smart4j.chapter2.basicmodule.util.CastUtil;
import org.smart4j.chapter2.basicmodule.util.StringUtil;

/**
 * 编辑客户
 */
@WebServlet("/customer_edit")
public class CustomerEditServlet extends HttpServlet {

    CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService =new CustomerService();
    }

    /**
     * 进入 编辑客户 界面
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Customer customer = null;
        if(StringUtil.isNotEmpty(id))
            customer = customerService.getCustomer(CastUtil.castLong(id));
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req,resp);
    }

    /**
     * 处理 编辑客户 请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,Object> map=new HashMap<String,Object>();

        String name = req.getParameter("name");
        String contact = req.getParameter("contact");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String id = req.getParameter("id");

        map.put("name",name);
        map.put("contact",contact);
        map.put("telephone",telephone);
        map.put("email",email);

        customerService.updateCustomer(CastUtil.castLong(id), map);
        req.getRequestDispatcher("/WEB-INF/view/customer_edit.jsp").forward(req,resp);
    }
}
