package com.fox.common;

import cn.supfox.boot.CommonBootstrap;
import cn.supfox.rest.GetRequestParam;
import cn.supfox.rest.RestTemplateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest(classes = CommonBootstrap.class)
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplateWrapper restTemplateWrapper;

    @Test
    public void testGet() {

//        Map<String, String> params = new HashMap<>();
//        params.put("name","test");
//        String result = restTemplate.getForObject("http://127.0.0.1:12345/rest/test", String.class, params);

        GetRequestParam getRequestParam = new GetRequestParam();
        getRequestParam.setName("test");
        String result = restTemplateWrapper.getForObject("http://127.0.0.1:12345/rest/test", String.class, getRequestParam);

        System.out.println(result);
    }


}
