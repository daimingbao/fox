package cn.com.fox.transaction;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "";

    double maxProgress() default 0;

    String name() default "";

}
