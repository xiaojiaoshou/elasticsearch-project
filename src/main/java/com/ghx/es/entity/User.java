package com.ghx.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 *
 * @description:
 * @type: JAVA
 * @since: 2020/10/25 18:51
 * @author: guohuixiang
 */

@Data
@Document(indexName = "mytest_user", type = "user", shards = 1, replicas = 0)
public class User implements Serializable {


    private static final long serialVersionUID = -7951183214408234692L;
    @Id
    private Long id;
    @Field("_name")
    private String name;
    @Field("_age")
    private Integer age;
    @Field("_message")
    private String message;

    private Long createId;

    private Long createTime;

    private Long updateId;

    @Field("_updateTime")
    private Long updateTime;

}
