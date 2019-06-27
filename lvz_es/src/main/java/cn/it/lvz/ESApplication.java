package cn.it.lvz;    /**
 * @description:
 * @author: flz
 * @date: 2019/6/4
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @description: 启动类
 * @author: flz
 * @date: 2019/06/04 13:44
 **/
@SpringBootApplication
@EntityScan({"cn.it.lvz.entity"})
@EnableElasticsearchRepositories(basePackages = "cn.it.lvz.repository")
public class ESApplication {
    public static void main(String[] args) {
        SpringApplication.run(ESApplication.class,args);
    }
}
