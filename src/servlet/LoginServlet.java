package servlet;

import po.Goods;
import po.User;
import service.GoodsService;
import service.UserService;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        User user = userService.checkUser(name, password);
        if (user == null) {
            request.getSession().setAttribute("msg", "用户不存在,请重新输入!!!");
            response.sendRedirect("login.jsp");
            return;
        }
        request.getSession().setAttribute("user", user);

        GoodsService goodsService = new GoodsService();
        List<Goods> goodsList = goodsService.getAllGoods();
        request.getSession().setAttribute("goodsList", goodsList);
        response.sendRedirect("index.jsp");

    }
}
