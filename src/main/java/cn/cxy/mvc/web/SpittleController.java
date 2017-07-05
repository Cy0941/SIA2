package cn.cxy.mvc.web;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping(value = "/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/{spittle_id}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("spittle_id") long spittleId, Model model) {
        model.addAttribute("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", required = false) Long max,
                           @RequestParam(value = "count", defaultValue = "20") int count,
                           Model model) { //cxy 此处 Model 可以使用 Map 代替
        if (null == max) {
            max = Long.MAX_VALUE;
        }
        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
        model.addAttribute("spittleList", spittles);
        System.out.println("----------spittles----------");
        return "spittles";
    }
}
