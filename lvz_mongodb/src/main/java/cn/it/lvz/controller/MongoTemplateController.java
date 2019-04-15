package cn.it.lvz.controller;

import cn.it.lvz.entity.NotifyMsg;
import cn.it.lvz.service.NotifyMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * mongoTemplate 示例
 *
 * @author oKong
 */
@RestController
@RequestMapping("/template")
@Slf4j
public class MongoTemplateController {

    @Autowired
    private NotifyMsgService notifyMsgService;

    @PostMapping("/add")
    public NotifyMsg add(NotifyMsg msg) {
        log.info("mongoTemplate方式新增：{}", msg);
        return notifyMsgService.saveMsg(msg);
    }

    @PostMapping("del/{id}")
    public NotifyMsg del(@PathVariable String id) {
        log.info("mongoTemplate方式删除：{}", id);
        return notifyMsgService.delNotifyMsgById(id);
    }

    @GetMapping("/find/{no}")
    public NotifyMsg findNotifyMsgByNo(@PathVariable String no) {
        log.info("mongoTemplate方式查找：notifyNo-{}", no);
        return notifyMsgService.findMsgByNo(no);
    }

    @GetMapping("/find/list/{date}")
    public List<NotifyMsg> findNotifyMsgByDate(@PathVariable String date) {
        log.info("mongoTemplate方式查找：notifyDate-{}", date);
        return notifyMsgService.findNotifyMsgByDate(date);
    }
}