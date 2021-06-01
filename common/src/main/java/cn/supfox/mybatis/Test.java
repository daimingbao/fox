package cn.supfox.mybatis;

import cn.supfox.mybatis.mapper.TestMapper;
import cn.supfox.mybatis.session.DefaultSqlSession;
import cn.supfox.mybatis.session.SqlSession;

public class Test {

    public static void main(String[] args) {

        SqlSession sqlSession = new DefaultSqlSession<>();
        sqlSession.getMapper(TestMapper.class, "1");
    }
}
