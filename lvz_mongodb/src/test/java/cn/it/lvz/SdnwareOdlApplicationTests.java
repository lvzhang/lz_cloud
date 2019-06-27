//package cn.it.lvz;
//
//import cn.it.lvz.dao.SNMPDao;
//import cn.it.lvz.dao.SNMPEntity;
//import javafx.application.Application;
//import org.bson.Document;
//import org.bson.types.ObjectId;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MongoApplication.class)
//public class SdnwareOdlApplicationTests {
//    @Autowired
//    SNMPDao snmpDao;
//
//    @Test
//    public void saveSNMPDataTests() {
//        List<Document> entrys = new ArrayList<>();
//        Document entry = new Document();
//        entry.put("ifIndex", 1);
//        entry.put("ifInOctets", 586888423);
//        entry.put("ifOutOctets", 1054861105);
//        entry.put("ifInUcastPkts", 24821672);
//        entry.put("ifOutUcastPkts", 15946353);
//        entry.put("ifSpeed", 1000000000);
//        entry.put("ifMtu", 1514);
//        entrys.add(entry);
//
//        SNMPEntity entity = new SNMPEntity();
//        entity.setId(ObjectId.get());
//        entity.setIfEntry(entrys);
//        entity.setIfRecvTime(LocalDateTime.now().plusHours(8));
//        entity.setIfNumber(49);
//        snmpDao.saveData(entity, "20180619");
//    }
//
//    @Test
//    public void getAllDataTests() {
//        List<SNMPEntity> entitys = snmpDao.getAllData("20180619");
//        for (SNMPEntity entity : entitys) {
//            LocalDateTime ifRecvTime = entity.getIfRecvTime();
//            System.out.println(ifRecvTime + ": ");
//            List<Document> ifEntrys = entity.getIfEntry();
//            for (Document ifEntry : ifEntrys) {
//                Integer ifIndex = ifEntry.getInteger("ifIndex");
//                Integer ifInOctets = ifEntry.getInteger("ifInOctets");
//                Integer ifOutOctets = ifEntry.getInteger("ifOutOctets");
//                System.out.println("ifIndex = " + ifIndex);
//                System.out.println("ifInOctets = " + ifInOctets);
//                System.out.println("ifOutOctets = " + ifOutOctets);
//            }
//        }
//    }
//}