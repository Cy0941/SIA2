package cn.cxy.mvc.data;

import cn.cxy.mvc.model.Spittle;

import java.util.List;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/6/13 23:35 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

}
