package cn.cxy.mvc.data.impl;

import cn.cxy.mvc.data.SpittleRepository;
import cn.cxy.mvc.model.Spitter;
import cn.cxy.mvc.model.Spittle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
        System.err.println("-----------SpittleRepositoryImpl----------");
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    public Spittle findOne(long spittleId) {
        System.out.println("----------findOne---------");
        return new Spittle("msg", new Date());
    }

    public void save(Spitter spitter) {
        System.err.println(spitter.getFirstName() + " : " + spitter.getLastName());
        System.out.println("--------save--------");
    }

    public Spitter findByUsername(String userName) {
        System.out.println("--------findByUsername--------");
        Spitter spittern= new Spitter();
        spittern.setUserName(userName);
        return spittern;
    }
}
