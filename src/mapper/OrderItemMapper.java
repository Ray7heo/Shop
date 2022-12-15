package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    @Insert("insert into order_item(price,amount,gid,oid)values(#{price},#{amount},#{id},#{oid})")
    void insertItem(@Param("price") float price, @Param("amount") int amount, @Param("id") int id, @Param("oid") int oid);
}
