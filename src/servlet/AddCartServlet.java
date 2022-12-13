package servlet;

import service.CartItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("userId");
        String gid = request.getParameter("goodsId");

        CartItemService cartItemService = new CartItemService();
        String msg = cartItemService.updateOrInsertCart(uid, gid);

        response.getOutputStream().print(msg);

    }
}
