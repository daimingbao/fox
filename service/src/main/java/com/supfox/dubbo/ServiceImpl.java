package com.supfox.dubbo;

import org.springframework.stereotype.Service;

/**
 * @author paul
 */
@Service
public class ServiceImpl implements FeignClientApi {
    @Override
    public String getName(DemoRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getTime());
        return request.getName();
    }
}
