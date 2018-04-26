package com.simonsfan.cn.util;


import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by fanrx on 2018/4/26.
 */
public class HttpClientUtil {
    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String ENCODING = "UTF-8";

    private static final int CONNECTION_TIME_OUT = 3000;

    private static final int SO_TIME_OUT = 5000;

    private static final boolean STALE_CHECK_ENABLED = true;

    private static final boolean TCP_NO_DELAY = true;

    private static final int DEFAULT_MAX_CONNECTIONS_PER_HOST = 100;

    private static final int MAX_TOTAL_CONNECTIONS = 1000;

    private static final HttpConnectionManager connectionManager;

    private static final HttpClient client;

    static {
        HttpConnectionManagerParams params = loadHttpConfFromFile();

        connectionManager = new MultiThreadedHttpConnectionManager();

        connectionManager.setParams(params);

        client = new HttpClient(connectionManager);
    }

    private static HttpConnectionManagerParams loadHttpConfFromFile() {  //这几个参数很重要
        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setConnectionTimeout(CONNECTION_TIME_OUT);  //连接超时时长
        params.setStaleCheckingEnabled(STALE_CHECK_ENABLED);   //是否启用旧连接检查
        params.setTcpNoDelay(TCP_NO_DELAY);
        params.setSoTimeout(SO_TIME_OUT);                //读取数据超时时长
        params.setDefaultMaxConnectionsPerHost(DEFAULT_MAX_CONNECTIONS_PER_HOST);  //由MultiThreadedHttpConnectionManager管理的最大连接数
        params.setMaxTotalConnections(MAX_TOTAL_CONNECTIONS);    //最大连接数
        params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
        return params;
    }

    /**
     * get请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        String result = null;
        try {
            GetMethod getMethod = new GetMethod(url);
            client.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("httpclient get request url=" + url + ",exception=" + e);
        }
        return result;
    }

    /**
     * 普通的post请求
     *
     * @param url
     * @return
     */
    public static String doPost(String url) {
        String result = null;
        try {
            PostMethod postMethod = new PostMethod(url);
            client.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            log.error("httpclient post request url=" + url + ",exception=" + e);
        }
        return result;
    }

    /**
     *  支持https请求的post
     *
     * @param httpsFlag
     * @param params
     * @param url
     * @return
     */
    public static String doPost(boolean httpsFlag, Map<String, String> params, String url) {
        org.apache.http.client.HttpClient client = new DefaultHttpClient();
        String result = "";
        try {
            if (httpsFlag) {
                client = WebClientWrapperUtil.wrapClient(client);
            }
            //设置超时时间
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000 * 3);
            HttpPost post = new HttpPost(url);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            if (MapUtils.isNotEmpty(params)) {
                Iterator<String> iterator = params.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    String value = params.get(key);
                    nameValuePairs.add(new BasicNameValuePair(key, value));
                }
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            }
            HttpResponse res = client.execute(post);
            result = streamToStr(res.getEntity().getContent(),ENCODING);
        } catch (Exception e) {
            log.error("url=" + url + "请求异常" + e.getMessage(), e);
        } finally {
            if (client != null) {
                client.getConnectionManager().shutdown();
            }
        }
        return result;
    }


    /**
     * InputStream--->String
     *
     * @param is
     * @param encoding
     * @return
     * @throws IOException
     */
    private static String streamToStr(InputStream is, String encoding) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is, encoding));
        StringBuffer sb = new StringBuffer();
        String str;
        while (StringUtils.isNotEmpty((str = in.readLine()))) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
/*        Map<String,String> map = new HashMap<>();
        map.put("req","sss");
        String s = HttpClientUtil.doPost(false,map,"http://×××/virtual/api/order/setRecord");*/

        String s = HttpClientUtil.doGet("http://localhost:80/common/checkfreejoin");

        System.out.println("result=" + s);
    }
}
