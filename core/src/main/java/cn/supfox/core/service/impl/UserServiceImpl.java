package cn.supfox.core.service.impl;

import cn.supfox.core.annotation.ExecuteSegment;
import cn.supfox.core.db.Score;
import cn.supfox.core.db.User;
import cn.supfox.core.mapper.UserMapper;
import cn.supfox.core.service.ScoreService;
import cn.supfox.core.service.SystemLogService;
import cn.supfox.core.service.UserService;
import cn.supfox.core.support.MyThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author dmb
 * @since 2020/2/20
 */
@Service
@Scope(scopeName = "prototype")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ScoreService socreService;

    @Autowired
    private SystemLogService systemLogService;

    public static int a = 0;

    @Override
    public void delete(User user) {

    }


    /**
     *     /**
     *      * 注册用户
     *      * 先新增用户，
     *      * 再增加积分
     *      * 最后记录日志
     *      *
     *      * 新增用户成功，增加积分成功
     *      * 新增用户失败，增加积分需要回滚
     *      * 新增积分失败，用户需要
     *      * 不管用户和积分是否成功，日志都要记录成功
     *
     *      第一种情况默认的事务传播机制
     *      全部都是 required 注册成功，积分主键冲突，用户信息可以成功保存 日志失败
     *      全部都是 required 注册失败，积分失败，日志失败
     *
     *
     *      第二种情况
     *      scoreService是requiredNew
     *      注册成功， 积分主键失败 用户信息成功 日志失败
     *
     * @param user
     */
    @Override
    @Transactional
    @ExecuteSegment(maxProgress = 1.0)
    public void register(User user) {
        //注册新用户
        userMapper.insertSelective(user);
        a++;
        System.out.println(a);
        //加积分
        Score score = new Score();
        score.setId(8);
        score.setTotal(10);

        //catch的情况 register方法不回滚 add方法回滚
//        try {
            socreService.add(score);
//        } catch (Exception e) {

//        }
//        throw new RuntimeException();

    }
}
