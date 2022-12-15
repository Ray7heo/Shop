package service;

import mapper.OrderItemMapper;
import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import po.Order;
import utils.DBUtil;

import java.io.IOException;
import java.util.List;

public class OrderService {

    public void addOrder(int id, float total, int amount) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.insertOrder(id, total, amount);
        sqlSession.commit();
        sqlSession.close();
    }

    public Order getOrderByTime() throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        return orderMapper.getOrderByTime();

    }

    public List<Order> getOrderByUid(int uid) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        return orderMapper.getOrderByUid(uid);
    }

    public void updateOrder(int id, int status, int paytype) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.updateOrder(id, status, paytype);
        sqlSession.commit();
        sqlSession.close();
    }
}
