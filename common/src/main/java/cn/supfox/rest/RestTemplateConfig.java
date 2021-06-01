package cn.supfox.rest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @ConditionalOnClass(value = RestTemplate.class)
    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();
        //默认使用的jdk的http请求组件 替换成okhttp3
        restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory());
        //使用自定义的uri处理器，实现参数追加到url的功能
        restTemplate.setUriTemplateHandler(new GetUriTemplateHandler());








        return restTemplate;
    }

    @Bean
    public RestTemplateWrapper restTemplateWrapper(RestTemplate restTemplate) {
        return new RestTemplateWrapper(restTemplate);
    }

}
