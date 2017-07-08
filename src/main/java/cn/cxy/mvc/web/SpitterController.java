package cn.cxy.mvc.web;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import javax.validation.Valid;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/7/5 18:27 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpitterController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        System.out.println("-------register--------");
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    /**
     * cxy @Valid 注解 - 启用在实体类中添加的校验注解
     *
     * @param spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processingRegistration(@RequestPart("profilePicture") byte[] profilePicture,@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {

        }
        spittleRepository.save(spitter);
        System.out.println("-------register--------");
        return "redirect:/spittles/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    private String showSpitterProfile(@PathVariable String userName, Model model) {
        Spitter spitter = spittleRepository.findByUsername(userName);
        model.addAttribute("spitter", spitter);
        return "profile";
    }

}
