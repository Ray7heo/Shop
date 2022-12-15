package servlet;

import po.Order;
import service.OrderItemService;
import service.OrderService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("status"));
        int paytype = Integer.parseInt(request.getParameter("paytype"));

        OrderService orderService = new OrderService();
        orderService.updateOrder(id, status, paytype);

        response.getOutputStream().print("ok");
    }
}
