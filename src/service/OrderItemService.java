package service;

import mapper.OrderItemMapper;
import org.apache.ibatis.session.SqlSession;
import po.OrderItem;
import utils.DBUtil;

import java.io.IOException;
import java.util.List;

public class OrderItemService {
    public void addOrderItem(float price, int amount, int id, int oid) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderItemMapper orderItemMapper = sqlSession.getMapper(OrderItemMapper.class);
        orderItemMapper.insertItem(price, amount, id, oid);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<OrderItem> getOrderItem(int id) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderItemMapper orderItemMapper = sqlSession.getMapper(OrderItemMapper.class);
        return orderItemMapper.getOrderItemById(id);
    }
}
