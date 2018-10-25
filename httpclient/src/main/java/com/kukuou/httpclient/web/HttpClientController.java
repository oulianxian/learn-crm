package com.kukuou.httpclient.web;

import com.kukuou.httpclient.commons.HttpClientUtils;
import com.kukuou.httpclient.server.HttpAPIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author olx
 * @date 2018/10/25/025
 */

@RestController
public class HttpClientController {


    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("httpclient")
    public String test() throws Exception {
        String str = httpAPIService.doGet("http://www.baidu.com");
        System.out.println(str);
        return "hello";
    }

    @RequestMapping("httpclient2")
    public String test2() throws Exception {
        String str = HttpClientUtils.doGet("http://www.baidu.com");
        System.out.println(str);
        return "hello";
    }

}
