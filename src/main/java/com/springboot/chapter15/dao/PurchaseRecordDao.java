package com.springboot.chapter15.dao;

import com.springboot.chapter15.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}
