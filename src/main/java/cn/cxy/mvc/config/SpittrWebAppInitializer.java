package cn.cxy.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

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
     * Spring 具体配置【ContextLoaderListener】
     * cxy 主要用于加载驱动后端的中间层及数据组件等
     *
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * SpringMVC 具体配置【DispatcherServlet】
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
}
