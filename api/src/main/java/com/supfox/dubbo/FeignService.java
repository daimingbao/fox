package com.supfox.dubbo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient("fox-server")
public interface FeignService {
    @PostMapping("/get")
    String getName(@RequestBody @Validated DemoRequest request);
}
