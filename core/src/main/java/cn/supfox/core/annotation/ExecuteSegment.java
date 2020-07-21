package cn.supfox.core.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExecuteSegment {

//    String value() default "";

    double minProgress() default 0;

    double maxProgress() default 0;

    String name() default "" ;

}
