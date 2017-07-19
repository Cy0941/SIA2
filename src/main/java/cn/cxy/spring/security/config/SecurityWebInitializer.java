package cn.cxy.spring.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

/**
 * Function: cxy 注册 DelegatingFilterProxy
 * Reason: TODO 继承 AbstractSecurityWebApplicationInitializer，不需要重载任何方法
 * Date: 2017/7/18 22:28 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Component
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
