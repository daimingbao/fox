package cn.supfox.mybatis.session;

import cn.supfox.mybatis.bind.MapperProxy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

@Slf4j
public class DefaultSqlSession<R> implements SqlSession {

    @Override
    public <T> T getMapper(Class clazz, Object param) {
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy<>(clazz, this));

        return (T) o;
    }

    @Override
    public <T> T selectOne(String var1) {
//        log.info("do db select one");
        return (T)var1;
    }
}
