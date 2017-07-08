package cn.cxy.mvc.annotation;

import java.lang.annotation.*;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/7/8 13:35 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MultipartAnnotation {

    //fixme 方法中作为参数的注解应该如何传参

}
