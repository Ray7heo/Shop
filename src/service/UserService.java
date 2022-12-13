package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import po.User;
import utils.DBUtil;

import java.io.IOException;

public class UserService {

    public User checkUser(String name, String password) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUser(name, password);
    }
}
