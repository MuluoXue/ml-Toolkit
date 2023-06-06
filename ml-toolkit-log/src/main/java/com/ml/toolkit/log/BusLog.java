package com.ml.toolkit.log;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusLog {
    /**
     * 功能名称
     * @return 名称
     */
    String name() default "";
    /**
     * 功能描述
     * @return 功能描述
     */
    String describe() default "";
}
