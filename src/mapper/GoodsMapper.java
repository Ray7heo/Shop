package mapper;

import org.apache.ibatis.annotations.Select;
import po.Goods;

import java.util.List;

public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> getAllGoods();

    @Select("select * from goods where id = #{id}")
    Goods getGoodsById(int id);

}
