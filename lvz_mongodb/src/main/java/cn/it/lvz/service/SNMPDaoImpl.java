package cn.it.lvz.service;

import cn.it.lvz.dao.SNMPDao;
import cn.it.lvz.dao.SNMPEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("snmpDao")
public class SNMPDaoImpl implements SNMPDao {

    static Logger logger = LoggerFactory.getLogger(SNMPDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveData(SNMPEntity entity, String collectionName) {
        mongoTemplate.save(entity, collectionName);
        logger.info("save snmp data in {} succeed.", collectionName);
    }


    @Override
    public List<SNMPEntity> getAllData(String collectionName) {
        return mongoTemplate.findAll(SNMPEntity.class, collectionName);
    }
}
