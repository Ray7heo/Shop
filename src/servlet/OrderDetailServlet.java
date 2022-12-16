package servlet;

import po.Goods;
import po.OrderItem;
import service.GoodsService;
import service.OrderItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/orderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderItemService orderItemService = new OrderItemService();

        List<OrderItem> orderItemList = orderItemService.getOrderItem(id);

        request.getSession().setAttribute("orderItemList", orderItemList);
        response.sendRedirect("orderDetail.jsp");
    }
}
