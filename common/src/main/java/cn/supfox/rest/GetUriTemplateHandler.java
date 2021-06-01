package cn.supfox.rest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplateHandler;

import java.net.URI;
import java.util.Map;

public class GetUriTemplateHandler implements UriTemplateHandler {

    private Logger log = LoggerFactory.getLogger("URI-HANDLER");

    private UriTemplateHandler uriTemplateHandler = new DefaultUriBuilderFactory();

    @Override
    public URI expand(String uriTemplate, Map<String, ?> uriVariables) {

        uriTemplate =  UriComponentsBuilder
                .fromHttpUrl(uriTemplate)
                .queryParams(new GetParamMultiValueMap(uriVariables)).toUriString();
        log.info("处理之后的url ==> {}", uriTemplate);
        return uriTemplateHandler.expand(uriTemplate, uriVariables);
    }

    @Override
    public URI expand(String uriTemplate, Object... uriVariables) {
        return uriTemplateHandler.expand(uriTemplate, uriVariables);
    }
}
