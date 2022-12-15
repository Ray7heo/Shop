package service;

import mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import po.Order;
import utils.DBUtil;

import java.io.IOException;

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
}
