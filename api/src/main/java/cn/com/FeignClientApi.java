package cn.com;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("fox-server")
public interface FeignClientApi extends FeignService {
}
