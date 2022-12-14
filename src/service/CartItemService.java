package service;

import mapper.CartItemMapper;
import org.apache.ibatis.session.SqlSession;
import po.CartItem;
import utils.DBUtil;

import java.io.IOException;
import java.util.List;

public class CartItemService {
    public String updateOrInsertCart(String uid, String gid) throws IOException {
        int id = Integer.parseInt(uid);
        int goodsId = Integer.parseInt(gid);

        SqlSession sqlSession = DBUtil.getSqlSession();
        CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
        CartItem cartItem = cartItemMapper.getCartItem(id, goodsId);

        if (cartItem == null) {
            cartItemMapper.insertItem(id, goodsId);
        } else {
            cartItemMapper.updateItem(id, goodsId);
        }
        sqlSession.commit();
        return "succeed";
    }

    public List<CartItem> getCartItemByUid(int uid) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
        return cartItemMapper.getCartItemByUid(uid);
    }

    public void delCartItemById(int id) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        CartItemMapper cartItemMapper = sqlSession.getMapper(CartItemMapper.class);
        cartItemMapper.delCartItemById(id);
        sqlSession.commit();
    }
}
