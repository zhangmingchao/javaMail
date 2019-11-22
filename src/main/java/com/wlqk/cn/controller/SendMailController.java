package com.wlqk.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/send")
public class SendMailController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public void sendMail(){

    }
}
