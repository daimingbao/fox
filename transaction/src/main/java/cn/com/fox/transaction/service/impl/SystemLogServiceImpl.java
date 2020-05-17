package cn.com.fox.transaction.service.impl;

import cn.com.fox.transaction.service.SystemLog;
import cn.com.fox.transaction.mapper.SystemLogMapper;
import cn.com.fox.transaction.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemLogServiceImpl implements SystemLogService {
    @Autowired
    private SystemLogMapper systemLogMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(SystemLog systemLog) {
        systemLogMapper.add(systemLog);
    }
}
