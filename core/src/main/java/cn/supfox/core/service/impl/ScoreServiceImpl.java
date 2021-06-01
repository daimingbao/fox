package cn.supfox.core.service.impl;


import cn.supfox.core.annotation.ExecuteSegment;
import cn.supfox.core.db.Score;
import cn.supfox.core.db.SystemLog;
import cn.supfox.core.mapper.ScoreMapper;
import cn.supfox.core.service.ScoreService;
import cn.supfox.core.service.SystemLogService;
import cn.supfox.core.service.UserService;
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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @ExecuteSegment(maxProgress = 2.0)
    public void add(Score score) {


        //新增积分
//        try {
            scoreMapper.add(score);
//        } catch (Exception e) {
//
//        }


        //记日志
        SystemLog systemLog = new SystemLog();
        systemLog.setLogId(18);
        systemLog.setLogDate(LocalDate.now());
//        systemLogService.add(systemLog);

    }
}
