package cn.cxy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

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

    private ServletContext servletContext;

    @Autowired
    public WebConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * 配置 Thymeleaf 视图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    /*@Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views/");
        resourceViewResolver.setSuffix(".jsp");
        //cxy 配置渲染视图类型
        resourceViewResolver.setViewClass(org.springframework.web.servlet_filter.view.JstlView.class);
        //TODO
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//cxy 配置静态资源的处理 - 将对静态资源的请求转发到Servlet容器中默认的Servlet上
    }

    /**
     * 配置Spring国际化，常用的两个解析类为：
     *  1、能够重新加载属性而不用重新编译或重启---支持类路径（以 classpath: 前缀）、文件系统（以 file: 前缀）、Web应用根路径（无前缀）
     *   org.springframework.context.support.ReloadableResourceBundleMessageSource
     *  2、会从一个属性文件中加载信息，属性文件的名称是根据基础名称衍生而来
     *   org.springframework.context.support.ResourceBundleMessageSource
     * @return
     */
    @Bean
    public MessageSource messageSource(){
        //ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        //resourceBundleMessageSource.setBasename("message");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    /**
     * 利用ApacheTiles视图定义布局
     * @return
     */
    //@Bean
    //public TilesConfigurer tilesConfigurer(){
    //    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    //    //设置tiles位置
    //    tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
    //    //启用自动刷新
    //    tilesConfigurer.setCheckRefresh(true);
    //    return tilesConfigurer;
    //}

    //@Bean
    //public ViewResolver viewResolver(){
    //    return new TilesViewResolver();
    //}

    /**
     * Servlet>=3.0 || Spring>=3.1 推荐使用 StandardServletMultipartResolver
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}
