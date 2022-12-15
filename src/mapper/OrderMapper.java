package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.Order;

public interface OrderMapper {
    @Insert("insert into tb_order(user_id,total,amount,status,paytype)values(#{id},#{total},#{amount},1,1)")
    void insertOrder(@Param("id") int id, @Param("total") float total, @Param("amount") int amount);

    @Select("select * from tb_order order by order_time desc limit 1")
    Order getOrderByTime();
}
