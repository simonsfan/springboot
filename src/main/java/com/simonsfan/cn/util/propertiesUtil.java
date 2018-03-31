package com.simonsfan.cn.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 读取资源文件
 *
 * Created by simonsfan
 */
public class PropertiesUtil {

    private static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);

    private static final String RESOUCE_CONFIG = "common.properties";

    private static Properties properties;

    private static ResourceBundle bundle;

    static {
        initBundle();
        initLoad();
    }

    private static void initLoad() {
        properties = new Properties();
        // 方式一获取流
        InputStream inputStream1 = PropertiesUtil.class.getResourceAsStream(RESOUCE_CONFIG);
        // 方式二获取流
        InputStream inputStream2 = PropertiesUtil.class.getClassLoader().getResourceAsStream(RESOUCE_CONFIG);
        // 方式三（此方式优先考虑）
        InputStream inputStream3 = Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOUCE_CONFIG);
        try {
            properties.load(inputStream3);
        } catch (Exception e) {
            log.error("PropertiesUtil read resouce file exception:{}", e);
        } finally {
            if (inputStream3 != null) {
                IOUtils.closeQuietly(inputStream3);
            }
        }
    }

    /**
     * 方式一:读取资源文件（流）
     *
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getByKey(String key, String defaultValue) {
        String value = properties.getProperty(key.trim());
        if (StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }

    // 方式二:读取资源文件（ResouceBundle）
    private static void initBundle() {
        bundle = ResourceBundle.getBundle("common");   //common是资源文件名
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getByResouceBundle(String key, String defaultValue) {
        String value = bundle.getString(key.trim());
        if (StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }

}

