package com.fox.mybatis.session;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultSqlSession<R> implements SqlSession {


    @Override
    public <T> T selectOne(String var1) {
//        log.info("do db select one");
        return (T)var1;
    }
}
