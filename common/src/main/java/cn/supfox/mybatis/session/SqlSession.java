package cn.supfox.mybatis.session;

public interface SqlSession {

    <T> T selectOne(String var1);

    <T> T getMapper(Class clazz, Object param);

}
