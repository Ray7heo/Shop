package servlet;

import po.CartItem;
import service.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showCartServlet")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));

        CartItemService cartItemService = new CartItemService();
        List<CartItem> cartItems = cartItemService.getCartItemByUid(uid);
        request.getSession().setAttribute("cartItems", cartItems);

        response.sendRedirect("cart.jsp");

    }
}
