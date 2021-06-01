package com.supfox.dubbo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Import(FoxDubboImportBeanDefinitionRegistrar.class)
public @interface FoxDubbo {
}
