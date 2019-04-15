package cn.it.lvz.service.impl;

import cn.it.lvz.entity.NotifyMsg;
import cn.it.lvz.service.NotifyMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: mongodb实现类
 * Define a  {@code NotifyMsgServiceImpl} implementations .
 *
 * @author: flz
 * @date: 2019/4/15
 */
@Service
public class NotifyMsgServiceImpl implements NotifyMsgService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public NotifyMsg saveMsg(NotifyMsg notifyMsg) {
        //使用 save和insert都可以进行插入
        //区别：当存在"_id"时
        //insert 插入已经存在的id时 会异常
        //save 则会进行更新
        //简单来说 save 就是不存在插入 存在更新
        mongoTemplate.insert(notifyMsg);
        mongoTemplate.save(notifyMsg);
        return null;
    }

    @Override
    public NotifyMsg findMsgByNo(String notifyNo) {
        //根据Criteria 改造查询条件
        Query query = new Query(Criteria.where("notifyNo").is(notifyNo));
        NotifyMsg notifyMsg = mongoTemplate.findOne(query, NotifyMsg.class);
        return notifyMsg;

    }

    @Override
    public List<NotifyMsg> findNotifyMsgByDate(String notifyDate) {
        //查找 notifyDate 根据Criteria 改造查询条件
        Query query = new Query(Criteria.where("notifyDate").is(notifyDate));
        List<NotifyMsg> notifyMsgList = mongoTemplate.find(query, NotifyMsg.class);
        return notifyMsgList;
    }

    @Override
    public NotifyMsg delNotifyMsgById(String id) {
        //查找 id 根据Criteria 改造查询条件
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query, NotifyMsg.class);
    }
}
