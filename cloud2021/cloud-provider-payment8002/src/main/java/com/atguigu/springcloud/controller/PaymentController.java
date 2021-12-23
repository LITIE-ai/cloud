package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: litie
 * @Date: 2021/12/08/18:16
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    String port;

    //插入数据
    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功！",result);
        }else{
            return new CommonResult(222,"插入数据失败！",null);
        }
    }
    //查询数据
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        System.out.println("port="+port);
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("*****查询结果："+paymentById);
        if(paymentById != null){
            return new CommonResult(200,"查询成功！",paymentById);
        }else{
            return new CommonResult(222,"没有对应记录，查询ID：" + id,null);
        }

    }

}
