package cn.cxy.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/13 22:56 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Controller
@RequestMapping({"/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        System.out.println("----------home-----------");
        return "home";
    }

    @RequestMapping(value = "spittler/register", method = RequestMethod.POST)
    public void register() {
        System.out.println("register");
    }

}
