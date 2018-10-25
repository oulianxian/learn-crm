package com.kukuou.httpclient.protocol;

/**
 * @author olx
 * @date 2018/10/25/025
 * 自定义返回结果类型
 */
public class HttpResult {

    // 响应的状态码

    private int code;

    // 响应的响应体

    private String body;

    public HttpResult(int code, String body) {
        this.code = code;
        this.body = body;
    }

    public HttpResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
