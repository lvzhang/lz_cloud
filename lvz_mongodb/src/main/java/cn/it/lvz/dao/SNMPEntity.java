package cn.it.lvz.dao;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Document
@Getter
@Setter
public class SNMPEntity implements Serializable {
    @Id
    private ObjectId id;
    @Field("ifRecvTime")
    private LocalDateTime ifRecvTime;
    @Field("ifEntry")
    private List<org.bson.Document> ifEntry;
    @Field("ifNumber")
    private Integer ifNumber;
}