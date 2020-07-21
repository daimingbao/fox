package cn.supfox.redis;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class RedisUtils {
    private static StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    private static Map<Class, Serializer> primitiveSerializers = new HashMap();

    public RedisUtils() {
    }

//    public static RedisSerializer determineRedisSerializer(Field field) {
//        Type[] types = getFieldTypes(field);
//        if (types[1] == Object.class) {
//            return new JdkSerializationRedisSerializer();
//        } else if (types[1] == String.class) {
//            return new StringRedisSerializer();
//        } else {
//            if (types[1] instanceof Class) {
//                Class clazz = (Class)types[1];
//                Serializer primitiveSerializer = (Serializer)primitiveSerializers.get(clazz);
//                if (primitiveSerializer != null) {
//                    return new SerializerAdapter(primitiveSerializer);
//                }
//            }
//
//            return new SerializerAdapter(new JsonSerializer(types[1]));
//        }
//    }

    public static Type getFieldType0(Field field) {
        return getFieldTypes(field)[0];
    }

    public static Type[] getFieldTypes(Field field) {
        Type cacheFieldType = field.getGenericType();
        if (cacheFieldType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)cacheFieldType;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types[0] != String.class && types[0] != Integer.class && types[0] != Long.class) {
                throw new IllegalStateException("redis cache泛型中的key目前只支持为String，Integer，Long类型");
            } else {
                return types;
            }
        } else {
            throw new IllegalStateException("redis cache泛型设置不对, 请使用如下形式Cache<String, ?> ");
        }
    }

    public static <V> RedisTemplate<String, V> createRedisTemplate(Field field, RedisConnectionFactory connectionFactory, Serializer serializer) {
        RedisTemplate<String, V> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        RedisSerializer redisSerializer = serializer != null ? new SerializerAdapter(serializer) : determineRedisSerializer(field);
//        redisTemplate.setValueSerializer((RedisSerializer)redisSerializer);
//        redisTemplate.setHashValueSerializer((RedisSerializer)redisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

//    public static CacheKeyPrefixGenerator getCacheKeyPrefixGenerator(Class<CacheKeyPrefixGenerator> cacheKeyPrefixGenerator, CacheConfig mergedConfig) {
//        if (cacheKeyPrefixGenerator != null) {
//            try {
//                Constructor<CacheKeyPrefixGenerator> constructor = cacheKeyPrefixGenerator.getConstructor(String.class, String.class);
//                String prefix = mergedConfig.getPrefix();
//                return (CacheKeyPrefixGenerator)constructor.newInstance(prefix, mergedConfig.getName());
//            } catch (Exception var4) {
//                throw new IllegalStateException(var4);
//            }
//        } else {
//            return null;
//        }
//    }

    static {
//        primitiveSerializers.put(Short.class, new JdkSerializationRedisSerializer());
//        primitiveSerializers.put(Byte.class, new ByteSerializer());
//        primitiveSerializers.put(Boolean.class, new BooleanSerializer());
//        primitiveSerializers.put(Integer.class, new IntegerSerializer());
//        primitiveSerializers.put(Double.class, new DoubleSerializer());
//        primitiveSerializers.put(Long.class, new LongSerializer());
//        primitiveSerializers.put(Float.class, new FloatSerializer());
//        primitiveSerializers.put(BigDecimal.class, new BigDecimalSerializer());
//        primitiveSerializers.put(BigInteger.class, new BigIntegerSerializer());
    }
}
