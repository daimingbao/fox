package cn.com.fox.transaction.service.impl;


import cn.com.fox.transaction.ExecuteSegment;
import cn.com.fox.transaction.mapper.ScoreMapper;
import cn.com.fox.transaction.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * @author dmb
 * @since 2020/2/21
 */
@Service
public class ScoreServiceImpl implements ScoreService {


    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private UserService userService;


    @Autowired
    private ScoreService socreService;


    @Autowired
    private SystemLogService systemLogService;


    /**
     * @param score
     */
    @Override
    @Transactional(propagation = Propagation.NESTED)
    @ExecuteSegment(maxProgress = 2.0)
    public void add(Score score) {


        //新增积分
        try {
//            scoreMapper.add(score);
        } catch (Exception e) {

        }


        //记日志
        SystemLog systemLog = new SystemLog();
        systemLog.setLogId(18);
        systemLog.setLogDate(LocalDate.now());
//        systemLogService.add(systemLog);

    }
}
