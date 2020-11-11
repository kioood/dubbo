package com.yzf.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yzf.service.IHelloWordService;

//当前的服务类对象由spring管理
//此处不使用spring的@Service注解 ，应该使用具有Rpc功能的dubbo的@Service
    @Service
    public class HelloServiceImpl implements IHelloWordService {
        @Override
        public String sayHello(String name) {
            return "Hello,"+name;
        }
    }