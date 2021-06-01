package com.supfox.dubbo;



/**
 * @author dmb
 * @since 2020/1/18
 */
@org.apache.dubbo.config.annotation.DubboService(connections = 2)
public class DubboServiceImpl implements DubboService {

    @Override
    public String test() {
        return "dubbo";
    }
}
