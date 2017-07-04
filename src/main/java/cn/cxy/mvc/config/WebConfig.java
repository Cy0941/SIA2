package cn.cxy.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Function: DispatcherServlet 配置
 * Reason: cxy useDefaultFilters --- Indicates whether automatic detection of classes annotated with {@code @Component},{@code @Repository},{@code @Service}, or {@code @Controller} should be enabled.
 * Date: 2017/6/13 19:13 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.cxy.mvc.web"},
               includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)},
               useDefaultFilters = false)
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        //TODO
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//cxy 配置静态资源的处理 - 将对静态资源的请求转发到Servlet容器中默认的Servlet上
    }
}
