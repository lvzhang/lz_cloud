package cn.it.lvz.repository;

import cn.it.lvz.entity.NotifyMsg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * MongoRepository 示例
 * 根据消息号进行查询
 *
 */
public interface NotifyMsgDao extends MongoRepository<NotifyMsg, String> {

    /**
     * 根据消息号进行查询
     * @param notifyNo
     * @return
     */
    NotifyMsg findByNotifyNo(String notifyNo);
    
    /**
     * 根据日期查询 自定义查询
     * 需要注意 查询的语法结构 ，同时这里和`jpa`不一样的地方是，第一个索引值从0 开始。。
     * @param notifyDate
     * @param pageable
     * @return
     */
    @Query("{'notifyDate':?0}")
    Page<NotifyMsg> queryBySql(String notifyDate, Pageable pageable);
}