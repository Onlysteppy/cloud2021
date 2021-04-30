package com.cry.springcloud.controller;

import com.cry.springcloud.entites.CommonResult;
import com.cry.springcloud.entites.Payment;
import com.cry.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        long startTime = System.currentTimeMillis();
        System.out.println("开始执行:");
        String s = paymentFeignService.paymentFeignTimeout();
        long endTime = System.currentTimeMillis();
        System.out.println("执行结束：花费"+(endTime -startTime));
        return s;
    }
}
