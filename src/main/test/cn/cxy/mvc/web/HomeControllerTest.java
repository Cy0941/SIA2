package cn.cxy.mvc.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/13 23:17 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class HomeControllerTest {
    @Test
    public void home() throws Exception {
        HomeController controller = new HomeController();
        //cxy 此种测试方法没有站在Spring控制视角的进行测试，仅断言返回值【对于请求方法及返回的视图这没有任何断言】
        //assertEquals("home",controller.home());

        //TODO Spring3.2开始支持mock SpringMVC 并针对控制器执行HTTP请求的机制
        //1、搭建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //2、对 "/" 执行GET请求并期望得到 home 视图
        mockMvc.perform(MockMvcRequestBuilders.get("/homepage")).andExpect(MockMvcResultMatchers.view().name("home"));
    }

}