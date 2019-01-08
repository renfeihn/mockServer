package com.dcits.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by renfei on 2019/1/8.
 */
public class CommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);


    /**
     * 获取json值
     *
     * @param json
     * @return
     */
    public static List<String> getServiceCode(String json) {
        List<String> values = new ArrayList<>();
//        String regex = "\"code\":\"(.*?)\\\"";  // JSON
        String regex = "<SvcCd>(.*?)</SvcCd>";  // XML
        Matcher matcher = Pattern.compile(regex).matcher(json);
        while (matcher.find()) {
            values.add(matcher.group(1));
        }

        return values;
    }


    /**
     * 读取文件
     *
     * @param filePath
     * @return
     */
    public static String readTxt(String filePath) {
        StringBuffer sb = new StringBuffer();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null) {
                    sb.append(lineTxt);
                }
                br.close();
            } else {
                logger.info("文件不存在!");
            }
        } catch (Exception e) {
            logger.error("文件读取错误!");
        }
        return sb.toString();
    }
}
