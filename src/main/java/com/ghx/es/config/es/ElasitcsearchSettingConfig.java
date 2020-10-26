package com.ghx.es.config.es;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @description:
 * @type: JAVA
 * @since: 2020/10/25 18:42
 * @author: guohuixiang
 */
@Configuration
@Data
public class ElasitcsearchSettingConfig {

    @Value("${elasticSearch.host.port}")
    private String hostAndPort;

    @Value("${elasticSearch.user}")
    private String user;
    @Value("${elasticSearch.password}")
    private String password;
    @Value("${elasticSearch.socketTimeout :5}")
    private long socketTimeout;
}
