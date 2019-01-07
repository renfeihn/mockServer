package com.dcits.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MockController {

    @RequestMapping(value = "/galaxy")
    @ResponseBody
    public String index(HttpServletRequest request, @RequestBody String body) throws IOException {

        String fileName = "";
        List<String> values = this.getServiceCode(body);
        if (null != values && values.size() > 0) {
            String serviceCode = values.get(0);
            fileName = this.getResponseFile(serviceCode);
        }


        return fileName;
    }


    public String getResponseFile(String serviceCode) {
        return PropertyUtil.getProperty(serviceCode);
    }

    /**
     * 获取json值
     *
     * @param json
     * @return
     */
    public List<String> getServiceCode(String json) {
        List<String> values = new ArrayList<>();
        String regex = "\"code\":\"(.*?)\\\"";
        Matcher matcher = Pattern.compile(regex).matcher(json);
        while (matcher.find()) {
            values.add(matcher.group(1));
        }

        return values;
    }
}

