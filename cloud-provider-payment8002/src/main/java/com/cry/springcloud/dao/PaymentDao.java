package com.cry.springcloud.dao;

import com.cry.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
