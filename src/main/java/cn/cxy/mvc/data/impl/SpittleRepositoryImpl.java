package cn.cxy.mvc.data.impl;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/14 0:14 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Repository
@Transactional
public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        System.out.println("-----------SpittleRepositoryImpl----------");
        return null;
    }
}
