package com.fox.redis;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.annotation.InjectionMetadata.InjectedElement;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractInjectBeanPostProcessor implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(AbstractInjectBeanPostProcessor.class);
    private final Map<String, InjectionMetadata> injectionMetadataCache = new ConcurrentHashMap(64);
    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet();

    public AbstractInjectBeanPostProcessor(Class<? extends Annotation> annotationClass) {
        this.autowiredAnnotationTypes.add(annotationClass);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        this.processInjection(bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    protected void processInjection(Object bean) {
        Class<?> clazz = bean.getClass();
        InjectionMetadata metadata = this.findAutowiringMetadata(clazz.getName(), clazz, (PropertyValues) null);

        try {
            metadata.inject(bean, (String) null, (PropertyValues) null);
        } catch (Throwable var5) {
            throw new BeanCreationException("Injection of autowired dependencies failed for class [" + clazz + "]", var5);
        }
    }

    private InjectionMetadata findAutowiringMetadata(String beanName, Class<?> clazz, PropertyValues pvs) {
        String cacheKey = StringUtils.hasLength(beanName) ? beanName : clazz.getName();
        InjectionMetadata metadata = (InjectionMetadata) this.injectionMetadataCache.get(cacheKey);
        if (InjectionMetadata.needsRefresh(metadata, clazz)) {
            synchronized (this.injectionMetadataCache) {
                metadata = (InjectionMetadata) this.injectionMetadataCache.get(cacheKey);
                if (InjectionMetadata.needsRefresh(metadata, clazz)) {
                    if (metadata != null) {
                        metadata.clear(pvs);
                    }

                    try {
                        metadata = this.buildAutowiringMetadata(clazz);
                        this.injectionMetadataCache.put(cacheKey, metadata);
                    } catch (NoClassDefFoundError var9) {
                        throw new IllegalStateException("Failed to introspect bean class [" + clazz.getName() + "] for autowiring metadata: could not find class that it depends on", var9);
                    }
                }
            }
        }

        return metadata;
    }

    private InjectionMetadata buildAutowiringMetadata(Class<?> clazz) {
        LinkedList<InjectedElement> elements = new LinkedList();
        Class targetClass = clazz;

        do {
            LinkedList<InjectedElement> currElements = new LinkedList();
            Field[] var5 = targetClass.getDeclaredFields();
            int var6 = var5.length;

            for (int var7 = 0; var7 < var6; ++var7) {
                Field field = var5[var7];
                InjectedElement injectedElement = this.create(field);
                if (injectedElement != null) {
                    currElements.add(injectedElement);
                }
            }

            elements.addAll(0, currElements);
            targetClass = targetClass.getSuperclass();
        } while (targetClass != null && targetClass != Object.class);

        return new InjectionMetadata(clazz, elements);
    }

    private InjectedElement create(Field field) {
        AnnotationAttributes ann = this.findAutowiredAnnotation(field);
        if (ann != null) {
            if (Modifier.isStatic(field.getModifiers())) {
                if (log.isWarnEnabled()) {
                    log.warn("Autowired annotation is not supported on static fields: " + field);
                }

                return null;
            } else {
                return this.create(ann, field);
            }
        } else {
            return null;
        }
    }

    protected abstract InjectedElement create(AnnotationAttributes var1, Field var2);

    private AnnotationAttributes findAutowiredAnnotation(AccessibleObject ao) {
        Iterator var2 = this.autowiredAnnotationTypes.iterator();

        AnnotationAttributes ann;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            Class<? extends Annotation> type = (Class) var2.next();

            ann = AnnotatedElementUtils.getMergedAnnotationAttributes(ao, type);
        } while (ann == null);

        return ann;
    }
}
