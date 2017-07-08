package cn.cxy.mvc.config;

import cn.cxy.mvc.servlet_filter.MyFilter;
import cn.cxy.mvc.servlet_filter.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Function: 通过实现 org.springframework.web.WebApplicationInitializer 添加自定义 Filter、Servlet等
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/7/8 10:50 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MyServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        //TODO 此种注册 Servlet 的方法不推荐 org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer.getServletConfigClasses() 会自动注册 DispatcherServlet
        //注册 Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        //映射 URL
        myServlet.addMapping("/customer/**");

        //注册 Filter
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null,false,"/customer/**");
    }
}
