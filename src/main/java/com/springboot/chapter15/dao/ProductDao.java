package com.springboot.chapter15.dao;

import com.springboot.chapter15.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface ProductDao {
    //获取产品
    public ProductPo getProduct(Long id);

    //减少库存 而@Param表明MyBatis参数传递给后台
    public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
