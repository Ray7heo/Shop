package mapper;

import org.apache.ibatis.annotations.*;
import po.CartItem;
import po.Goods;

import java.util.List;

public interface CartItemMapper {
    @Select("select * from cart_item where user_id=#{uid} and gid=#{gid}")
    CartItem getCartItem(@Param("uid") int uid, @Param("gid") int gid);

    @Insert("insert into cart_item(user_id,gid,amount)values(#{uid},#{gid},1)")
    void insertItem(@Param("uid") int uid, @Param("gid") int gid);

    @Update("update cart_item set amount=amount+1 where user_id=#{uid} and gid=#{gid}")
    void updateItem(@Param("uid") int uid, @Param("gid") int gid);

    @Select("select * from cart_item where user_id = #{uid}")
    @Results(id = "cartMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "goods", column = "gid", javaType = Goods.class, one = @One(select = "mapper.GoodsMapper.getGoodsById")),
            @Result(property = "amount", column = "amount")
    })
    List<CartItem> getCartItemByUid(int uid);

}
