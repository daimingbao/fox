package cn.com;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fox.redisson")
@Data
public class RedissonProperties {

    private int connectTimeout = 10000;

    private String host;

    private String port;

}
