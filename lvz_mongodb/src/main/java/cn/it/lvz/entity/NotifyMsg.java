package cn.it.lvz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知消息对象
 *
 * @author oKong
 */
@Document(collection = "notify_msg")//集合名
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotifyMsg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8985545025018238754L;

    @Id
    private String id;

    /**
     * 消息类型
     */
    @Indexed
    private String notifyType;

    /**
     * 消息单号
     */
    @Indexed
    private String notifyNo;

    /**
     * 消息通知日期
     */
    private String notifyDate;

    /**
     * 消息体/可指定存储时的字段名
     */
    @Field("notifyMsg")
    private String notifyMsg;

    /**
     * 创建时间
     */
    @CreatedDate
    private Date gmtCreate;
}