package cn.cxy.mvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Function: TODO
 * Reason: TODO 使用 Spring 对 Java 校验API（JSR-303），位于 javax.validation.constraints 包中
 * 需要在对应的控制器 Controller 上使用注解 @Valid 启用校验
 * Date: 2017/6/15 0:05 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Getter
@Setter
public class Spitter {

    @NotNull
    @Size(min = 5, max = 16, message = "{firstName.size}")//TODO 校验不通过时需要显示的详细信息
    private String firstName;

    @NotNull
    @Size(min = 5, max = 25, message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Size(min = 2, max = 30, message = "{userName.size}")
    private String userName;

    @NotNull
    @Size(min = 2, max = 30, message = "{password.size}")
    private String password;

}
