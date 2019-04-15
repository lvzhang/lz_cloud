package cn.it.lvz.controller;

import cn.it.lvz.entity.NotifyMsg;
import cn.it.lvz.repository.NotifyMsgDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * MongoRepository MongoRepository方式
 *
 * @author oKong
 */
@RestController
@RequestMapping("/repository")
@Slf4j
public class MongoRepositoryController {

    @Autowired
    NotifyMsgDao notifyMsgDao;

    @PostMapping("/add")
    public NotifyMsg add(NotifyMsg msg) {
        log.info("repository方式新增：{}", msg);
        return notifyMsgDao.save(msg);
    }

    @GetMapping("/find/sql/{date}")
    public Page<NotifyMsg> queryBySql(@PathVariable String date) {
        Pageable pageable = new PageRequest(0, 10);
        log.info("repository方式分页sql查找日期：{}", date);
        return notifyMsgDao.queryBySql(date, pageable);
    }

    @GetMapping("/find/{no}")
    public NotifyMsg findByNotifyNo(@PathVariable String no) {
        log.info("repository方式查找单号：{}", no);
        return notifyMsgDao.findByNotifyNo(no);
    }

}