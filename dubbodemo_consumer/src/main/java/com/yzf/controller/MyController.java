package com.yzf.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.yzf.service.IHelloWordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc")
public class MyController {
    //要去调用provider中的Service，要求先注入Service
    //>1 复制provider工程的service接口，com.wzx.service.IHelloService
    //>2 使用注入，但是不使用spring的autowire,而使用是dubbo的@Service配对的
    @Reference
    IHelloWordService iHelloWordService;//去provider取对象
    @RequestMapping(path = "/test01",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    String test01(String name){
        String r =  iHelloWordService.sayHello(name);
        return r;//会将ResponseBody将r转成json
    }

}
