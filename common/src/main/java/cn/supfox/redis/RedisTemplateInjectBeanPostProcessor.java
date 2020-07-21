package cn.supfox.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public class RedisTemplateInjectBeanPostProcessor extends AbstractInjectBeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(RedisTemplateInjectBeanPostProcessor.class);
    private static StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    private RedisConnectionFactory redisConnectionFactory;

    public RedisTemplateInjectBeanPostProcessor() {
        super(RedisInject.class);
    }

    protected InjectionMetadata.InjectedElement create(AnnotationAttributes annotationAttributes, Field field) {
        return new RedisTemplateInjectBeanPostProcessor.RedisInjectedElement(field, (PropertyDescriptor) null, this.redisConnectionFactory);
    }

    public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    static class RedisInjectedElement extends InjectionMetadata.InjectedElement {
        private RedisConnectionFactory redisConnectionFactory;

        protected RedisInjectedElement(Member member, PropertyDescriptor pd, RedisConnectionFactory redisConnectionFactory) {
            super(member, pd);
            this.redisConnectionFactory = redisConnectionFactory;
        }

        protected Object getResourceToInject(Object target, String requestingBeanName) {
            RedisTemplate redisTemplate = new RedisTemplate();
            redisTemplate.setConnectionFactory(this.redisConnectionFactory);
            redisTemplate.setKeySerializer(RedisTemplateInjectBeanPostProcessor.stringRedisSerializer);
            redisTemplate.setHashKeySerializer(RedisTemplateInjectBeanPostProcessor.stringRedisSerializer);
//            RedisSerializer redisSerializer = RedisUtils.determineRedisSerializer((Field) this.member);
//            redisTemplate.setValueSerializer(redisSerializer);
//            redisTemplate.setHashValueSerializer(redisSerializer);
            redisTemplate.afterPropertiesSet();
            return redisTemplate;
        }
    }
}
