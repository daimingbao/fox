package cn.com.fox.mybatis;

import cn.com.fox.mybatis.bind.MapperProxy;
import cn.com.fox.mybatis.mapper.TestMapper;
import cn.com.fox.mybatis.session.DefaultSqlSession;
import cn.com.fox.mybatis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class MapperProxyTest {

    public static void main(String[] args) {

        SqlSession sqlSession = new DefaultSqlSession<>();
    TestMapper object = (TestMapper) Proxy.newProxyInstance(TestMapper.class.getClassLoader(), new Class[]{TestMapper.class},new MapperProxy<>(TestMapper.class, sqlSession));

    log.info("{}", object.selectOne("hello"));
    }

}
