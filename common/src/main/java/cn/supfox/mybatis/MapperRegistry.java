package cn.supfox.mybatis;


import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();
}
