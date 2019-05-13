package cn.it.lvz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * Define a  {@code MybatisPlusApplication} implementations .
 *
 * @author: flz
 * @date: 2019/4/18
 */
@SpringBootApplication
@MapperScan("cn.it.lvz.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
