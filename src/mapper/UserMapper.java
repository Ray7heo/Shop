package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.User;

public interface UserMapper {
    @Select("select * from tb_user where name=#{name} and password=#{password}")
    User getUser(@Param("name") String name, @Param("password") String password);
}
