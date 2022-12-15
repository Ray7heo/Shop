package service;

import mapper.OrderItemMapper;
import org.apache.ibatis.session.SqlSession;
import utils.DBUtil;

import java.io.IOException;

public class OrderItemService {
    public void addOrderItem(float price, int amount, int id, int oid) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        OrderItemMapper orderItemMapper = sqlSession.getMapper(OrderItemMapper.class);
        orderItemMapper.insertItem(price, amount, id, oid);
        sqlSession.commit();
        sqlSession.close();
    }
}
