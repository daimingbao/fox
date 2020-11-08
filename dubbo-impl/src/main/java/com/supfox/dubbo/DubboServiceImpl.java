package com.supfox.dubbo;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author dmb
 * @since 2020/1/18
 */
@Service(connections = 2)
public class DubboServiceImpl implements DubboService {

    @Override
    public String test() {
        return "dubbo";
    }
}
