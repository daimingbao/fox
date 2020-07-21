package cn.supfox.mybatis.session;

public interface SqlSession {

    <T> T selectOne(String var1);

}
