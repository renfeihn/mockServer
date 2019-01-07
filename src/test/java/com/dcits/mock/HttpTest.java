package com.dcits.mock;

public class HttpTest {


    public static void main(String[] args) {
        //发送 POST 请求
        String sr = HttpRequest.sendPost("http://localhost:8080/galaxy", "{\"dd\":\"fffff\"}");
        System.out.println(sr);
    }

}
