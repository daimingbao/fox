package cn.supfox.rest;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateWrapper extends RestTemplate {

    private RestTemplate restTemplate;

    public RestTemplateWrapper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T getForObject(String url, Class<T> responseType, Object paramBean) throws RestClientException {

        Map<String, String> paramMap = null;
        try {
            paramMap = BeanUtilsBean.getInstance().describe(paramBean);
        } catch (Exception e) {
            logger.error("请求参数处理异常");
        }
        return restTemplate.getForObject(url, responseType, paramMap);
    }
}
