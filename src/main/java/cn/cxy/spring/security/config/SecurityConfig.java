package cn.cxy.spring.security.config;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.spring.security.service.MyUserDetailService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/7/18 22:37 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Component
@EnableWebSecurity // cxy 启用Security功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    private SpittleRepository spittleRepository;

    public void setSpittleRepository(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 配置如何通过拦截器保护请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated() //要求所有进入应用的HTTP请求都要进行认证
                .and()
                .formLogin().and()
                .httpBasic();

        http.authorizeRequests()
                .antMatchers("/spitters/me").authenticated()
                .antMatchers(HttpMethod.POST,"/spittles").authenticated()
                .anyRequest().permitAll();

        http.authorizeRequests()
                .antMatchers("spitters/me").hasAuthority("ROLE_SPITTER")
                .antMatchers(HttpMethod.POST,"/spittlees").hasAuthority("ROLE_SPITTER")
                .anyRequest().permitAll();

        http.authorizeRequests()
                .antMatchers("/spitters/me").access("hasRole('ROLE_SPITTER') and hasIpAddress('192.168.1.1')")
                .anyRequest().permitAll()
                .and()
                //TODO 需要https访问
                .requiresChannel()
                .antMatchers("/spitter/form").requiresSecure()
                //TODO 不需要 https 访问
                .antMatchers("/spitter","/").requiresInsecure();
    }

    /**
     * 配置 user-detail 服务
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //.roles("USER") 等同于 authorities("ROLE_USER") -- cxy 会自动添加 ROLE_ 前缀
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true from Spitter where username = ?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));

        //设置自定义 UserDetailsService
        auth.userDetailsService(new MyUserDetailService(spittleRepository));
    }

    /**
     * 配置 Filter 链
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
