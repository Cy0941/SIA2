package cn.cxy.mvc.config;

import cn.cxy.mvc.servlet_filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * Function: 继承自 AbstractAnnotationConfigDispatcherServletInitializer，作用等同于 web.xml
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/13 19:14 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring 具体配置 --  applicationContext.xml -- 注册 ContextLoaderListener 时调用
     * cxy 主要用于加载驱动后端的中间层及数据组件等
     *
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * SpringMVC 具体配置 --  spring-dispatcher.xml  --  注册 DispatcherServlet 时调用
     * cxy 用于加载包含web组件的bean，如控制器、视图解析器、处理器映射等
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 /
     * cxy "/" - 表示该 Servlet 为默认；会处理进入此应用的所有请求
     *
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 通过注册 DispatcherServlet 开启 multipart 的支持
     *
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //cxy 使用StandardServletMultipartResolver 时必须指定上传时的临时目录
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("tmp/spittr/uploads",2097152,4194304,0);
        registration.setMultipartConfig(multipartConfigElement);
    }

    /**
     * 没有必要声明映射路径，该方法返回的所有 Filter 都会映射到 DispatcherServlet 上
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        //TODO 自定义 Filter / Listener 等
    }
}
