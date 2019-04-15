package cn.it.lvz.service;

import cn.it.lvz.entity.NotifyMsg;

import java.util.List;

/**
 * Description:mongodb接口服务
 * Define a  {@code NotifyMsgService} implementations .
 *
 * @author: flz
 * @date: 2019/4/15
 */
public interface NotifyMsgService {
    /**
     * 保存数据
     *
     * @param notifyMsg
     * @return
     */
    NotifyMsg saveMsg(NotifyMsg notifyMsg);

    /**
     * 根据消息号查询
     *
     * @param notifyNo
     * @return
     */
    NotifyMsg findMsgByNo(String notifyNo);

    /**
     * 根据时间查询
     *
     * @param notifyDate
     * @return
     */
    List<NotifyMsg> findNotifyMsgByDate(String notifyDate);

    /**
     * 根据时间查询
     *
     * @param id
     * @return
     */
    NotifyMsg delNotifyMsgById(String id);
}
