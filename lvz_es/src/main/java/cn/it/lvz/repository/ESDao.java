package cn.it.lvz.repository;


import cn.it.lvz.entity.ElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ESDao extends ElasticsearchRepository<ElasticEntity, String> {
    ElasticEntity queryEmployeeById(String id);
}

