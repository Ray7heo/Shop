package servlet;

import po.CartItem;
import po.User;
import service.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/delCartItemServlet")
public class DelCartItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cid"));
        User user = (User) request.getSession().getAttribute("user");

        CartItemService cartItemService = new CartItemService();
        cartItemService.delCartItemById(id);

        List<CartItem> cartItems = cartItemService.getCartItemByUid(user.getId());

        request.getSession().setAttribute("cartItems", cartItems);
        response.sendRedirect("cart.jsp");
    }
}
