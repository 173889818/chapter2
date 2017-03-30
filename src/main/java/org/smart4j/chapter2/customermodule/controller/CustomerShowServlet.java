package org.smart4j.chapter2.customermodule.controller;

import org.smart4j.chapter2.customermodule.model.Customer;
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
 * 显示客户基本信息
 */
@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {

    CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService =new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Customer customer = null;
        if(StringUtil.isNotEmpty(id))
            customer = customerService.getCustomer(CastUtil.castLong(id));
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("/WEB-INF/view/customer_show.jsp").forward(req,resp);
    }
}
