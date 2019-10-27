package com.fox.mybatis.session;

public interface SqlSession {

    <T> T selectOne(String var1);

}
