package com.aiitec.base.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 约定有这种标注都不要进行混淆，便于proguard识别，不需要每个目录或者包名做区分 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoConfound {
    String value() default "";
}
