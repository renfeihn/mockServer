package com.dcits.mock;

import com.dcits.common.CommonUtil;
import com.dcits.common.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MockController {

    private static final Logger logger = LoggerFactory.getLogger(MockController.class);


    @RequestMapping(value = "/clp")
    @ResponseBody
    public String index(HttpServletRequest request, @RequestBody String body) throws IOException {

        String response = "";

        List<String> values = CommonUtil.getServiceCode(body);
        if (null != values && values.size() > 0) {
            String serviceCode = values.get(0);
            String fileName = PropertyUtil.getProperty(serviceCode);

            StringBuffer sb = new StringBuffer(System.getProperty("user.dir"));
            sb.append(File.separator).append("response");

//            String responsePath = MockController.class.getClassLoader().getResource("response").getPath();
            if (logger.isDebugEnabled()) {
                logger.debug("responsePath :{}", sb.toString());
            }

            String filePath = sb.toString() + File.separator + fileName;
            if (logger.isDebugEnabled()) {
                logger.debug("filePath :{}", filePath);
            }
            response = CommonUtil.readTxt(filePath);

        }

        return response;
    }


}

