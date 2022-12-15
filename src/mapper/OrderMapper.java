package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.Order;

import java.util.List;

public interface OrderMapper {
    @Insert("insert into tb_order(user_id,total,amount,status,paytype)values(#{id},#{total},#{amount},1,1)")
    void insertOrder(@Param("id") int id, @Param("total") float total, @Param("amount") int amount);

    @Select("select * from tb_order order by order_time desc limit 1")
    Order getOrderByTime();

    @Select("select * from tb_order where user_id = #{uid}")
    List<Order> getOrderByUid(int uid);
}
