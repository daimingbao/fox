package cn.supfox.transaction.service.impl;


import cn.supfox.transaction.db.SystemLog;
import cn.supfox.transaction.mapper.SystemLogMapper;
import cn.supfox.transaction.service.SystemLogService;
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
