package cn.cxy.mvc.web;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/14 0:16 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
@Controller
@RequestMapping(value = "/spittle")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String spittles(Model model) {
        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
        model.addAttribute("spittleList", spittles);
        System.out.println("----------spittles----------");
        return "spittles";
    }
}
