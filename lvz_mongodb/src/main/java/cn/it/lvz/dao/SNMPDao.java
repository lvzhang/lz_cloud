package cn.it.lvz.dao;


import java.util.List;

public interface SNMPDao {
    void saveData(SNMPEntity entity, String collectionName);
    List<SNMPEntity> getAllData(String collectionName);
}
