package service;

import mapper.GoodsMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import po.Goods;
import utils.DBUtil;

import java.io.IOException;
import java.util.List;

public class GoodsService {
    public List<Goods> getAllGoods() throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        return goodsMapper.getAllGoods();
    }
}
