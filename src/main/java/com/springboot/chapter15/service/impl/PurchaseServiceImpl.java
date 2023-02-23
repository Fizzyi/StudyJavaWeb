package com.springboot.chapter15.service.impl;

import com.springboot.chapter15.dao.ProductDao;
import com.springboot.chapter15.dao.PurchaseRecordDao;
import com.springboot.chapter15.pojo.ProductPo;
import com.springboot.chapter15.pojo.PurchaseRecordPo;
import com.springboot.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductDao productDao = null;
    @Autowired
    private PurchaseRecordDao purchaseRecordDao = null;


    @Override
    @Transactional //启动Spring数据库事务机制
    public boolean purchase(Long userId, Long productId, int quantity) {
        //获取产品
        ProductPo product = productDao.getProduct(productId);
        //比较库存和购买数量
        if (product.getStock() < quantity) {
            //库存不足
            return false;
        }
        //扣减库存
        productDao.decreaseProduct(productId, quantity);
        //初始化购买记录
        PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
        //插入购买记录
        purchaseRecordDao.insertPurchaseRecord(pr);
        return true;
    }

    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
