package cn.cxy.spring.security.service;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spitter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/7/18 23:24 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public class MyUserDetailService implements UserDetailsService {

    private SpittleRepository spittleRepository;

    public MyUserDetailService(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spittleRepository.findByUsername(username);
        if (null != spitter) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(username,spitter.getPassword(),authorities);
        }
        throw new UsernameNotFoundException("User: "+username+" not found");
    }
}
