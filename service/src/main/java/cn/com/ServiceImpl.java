package cn.com;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements FeignService {
    @Override
    public String getName(DemoRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getTime());
        return request.getName();
    }
}
