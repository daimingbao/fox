package cn.supfox.core.service.impl;


import cn.supfox.core.db.SystemLog;
import cn.supfox.core.mapper.SystemLogMapper;
import cn.supfox.core.service.SystemLogService;
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
