package servlet;

import po.Order;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showOrderServlet")
public class ShowOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getOrderByUid(uid);
        request.getSession().setAttribute("orderList", orderList);
        response.sendRedirect("order.jsp");
    }
}
