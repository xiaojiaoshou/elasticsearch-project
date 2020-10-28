package com.ghx.es.controller;

import com.ghx.es.entity.User;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @description:
 * @type: JAVA
 * @since: 2020/10/25 19:07
 * @author: guohuixiang
 */
@RequestMapping("/user")
@RestController
public class UserController {

    //  es 原生api
    // private RestHighLevelClient restHighLevelClient;

    // spirng data repository  api  自动 实现了存储接口
    // ElasticsearchRepository elasticsearchRepository;


    //
    // private ElasticsearchOperations elasticsearchOperations;

    /**
     * 封装处理了 es文档和java 实体pojo 的对象映射  我们选择 elasticsearchRestTemplate 进行操作
     *
     * ElasticsearchRestTemplate  是 elasticsearchOperations 的实现
     */
    @Autowired
    private ElasticsearchRestTemplate restTemplate;


    @RequestMapping("/getUserById")
    public User getUserById(Long id) {

        User user = restTemplate
                // .queryForObject(GetQuery.getById(id.toString()), User.class);
                .get(id.toString(), User.class);
        return user;

    }

}
