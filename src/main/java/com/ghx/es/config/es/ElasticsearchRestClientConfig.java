package com.ghx.es.config.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.time.Duration;

/**
 *
 * @description:
 * @type: JAVA
 * @since: 2020/10/25 18:35
 * @author: guohuixiang
 */
@Configuration
public class ElasticsearchRestClientConfig extends AbstractElasticsearchConfiguration {

    @Autowired
    private ElasitcsearchSettingConfig elasitcsearchSettingConfig;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200", "localhost:9291")
//                .useSsl()
//                .withProxy("localhost:8888")
//                .withPathPrefix("ela")
//                .withConnectTimeout(Duration.ofSeconds(5))
//                .withSocketTimeout(Duration.ofSeconds(3))
//                .withDefaultHeaders(defaultHeaders)
//                .withBasicAuth(username, password)
//                .withHeaders(() -> {
//                    HttpHeaders headers = new HttpHeaders();
//                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//                    return headers;
//                })
//                . // ... other options
//  .build();

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                // .connectedTo("localhost:9200")
                .connectedTo(elasitcsearchSettingConfig.getHostAndPort())
                // 连接超时时间
                .withConnectTimeout(Duration.ofSeconds(10))
                .withSocketTimeout(Duration.ofSeconds(5))
                //.withBasicAuth(username, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchRestTemplate restTemplate() throws Exception {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
