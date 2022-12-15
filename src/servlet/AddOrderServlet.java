package servlet;

import po.CartItem;
import po.Order;
import po.User;
import service.CartItemService;
import service.OrderItemService;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checked = request.getParameter("checked");
        String[] checkId = checked.split(",");
        User user = (User) request.getSession().getAttribute("user");
        List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("cartItems");
        List<CartItem> orderItems = new ArrayList<>();
        for (String ID : checkId) {
            for (CartItem item : cartItems) {
                int id = Integer.parseInt(ID);
                if (item.getId() == id) {
                    orderItems.add(item);
                }
            }
        }
        int amount = 0;
        float total = 0;
        for (CartItem item : orderItems) {
            amount += item.getAmount();
            total += item.getAmount() * item.getGoods().getPrice();
        }
        //1插入order
        OrderService orderService = new OrderService();
        orderService.addOrder(user.getId(), total, amount);
        //2插入orderItem
        Order order = orderService.getOrderByTime();
        OrderItemService orderItemService = new OrderItemService();
        for (CartItem item : orderItems) {
            orderItemService.addOrderItem(item.getGoods().getPrice(), item.getAmount(), item.getGoods().getId(), order.getId());
        }
        //3删除orderItem
        CartItemService cartItemService = new CartItemService();
        for (CartItem item : orderItems) {
            cartItemService.delCartItemById(item.getId());
        }
        //4重新获取购物车
        List<CartItem> newCartItems = cartItemService.getCartItemByUid(user.getId());
        request.getSession().setAttribute("cartItems", newCartItems);
        response.getOutputStream().print(checked);
    }
}
