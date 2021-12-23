package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: litie
 * @Date: 2021/12/08/18:05
 */
public interface PaymentService {
    public int create(Payment payment); //写
    public Payment getPaymentById(Long id);  //读取
}
