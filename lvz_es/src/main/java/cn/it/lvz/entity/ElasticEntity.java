package cn.it.lvz.entity;    /**
 * @description:
 * @author: flz
 * @date: 2019/6/4
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @description: 实体类
 * @author: flz
 * @date: 2019/06/04 11:26
 **/
@Document(indexName = "test-boot",type = "goods",shards = 1,replicas = 0, refreshInterval = "-1")
@Getter
@Setter
public class ElasticEntity implements Serializable {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String content;
    @Field
    private String price;
}
