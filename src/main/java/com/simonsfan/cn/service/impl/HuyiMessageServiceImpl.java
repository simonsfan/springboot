package com.simonsfan.cn.service.impl;

import com.simonsfan.cn.service.HuyiMessageService;
import com.simonsfan.cn.util.HttpClientUtil;
import com.simonsfan.cn.util.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

/**
 * Created by fanrx on 2018/5/18.
 */
@Service
public class HuyiMessageServiceImpl implements HuyiMessageService {

    private static final Logger log = LoggerFactory.getLogger(HuyiMessageServiceImpl.class);

    @Override
    public String sendMessage(String phone, String content) {
        String result = "";
        try {
            String url = PropertyUtils.getByKey("huyi.postmessage.url", "http://106.ihuyi.com/webservice/sms.php?method=Submit");
            String apiId = PropertyUtils.getByKey("huyi.apiid", "C61993945");
            String password = PropertyUtils.getByKey("huyi.password", "053296671514a70dee7132759875a741");
            String content1 = URLEncoder.encode(content,"UTF-8");   //httpclient模拟的请求参数中包含中文一定要先encode，不然会导致调用失败
            StringBuffer sb = new StringBuffer(url);
            sb.append("&account=").append(apiId).
                    append("&password=").append(password).
                    append("&mobile=").append(phone).
                    append("&content=").append(content1).
                    append("&format=json");
            String param = sb.toString();
            result = HttpClientUtil.doGet(param);
            log.info("huyi send message result=" + result);
        } catch (Exception e) {
            log.info("sendmessage exception=" + e);
        }
        return result;
    }

}
