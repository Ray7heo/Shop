package mapper;

import org.apache.ibatis.annotations.*;
import po.Goods;
import po.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    @Insert("insert into order_item(price,amount,gid,oid)values(#{price},#{amount},#{id},#{oid})")
    void insertItem(@Param("price") float price, @Param("amount") int amount, @Param("id") int id, @Param("oid") int oid);

    @Select("select * from order_item where oid = #{id}")
    @Results(id = "orderMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "goods", column = "gid", javaType = Goods.class, one = @One(select = "mapper.GoodsMapper.getGoodsById"))
    })
    List<OrderItem> getOrderItemById(int id);
}
