package com.atguigu.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: litie
 * @Date: 2021/12/09/11:03
 */
@SpringBootConfiguration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //通过注册中心获取服务列表，远程调用采用负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
