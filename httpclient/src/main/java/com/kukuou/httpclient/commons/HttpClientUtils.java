package com.kukuou.httpclient.commons;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;


/**
 * Created by frt on 2017/10/30.
 *
 */
public class HttpClientUtils {
    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static CloseableHttpClient httpClient = null;
    private static final String DEFAULT_CHARSET = "UTF-8";

    private HttpClientUtils(){

    }

    static {
        ConnectionSocketFactory plainFactory = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslFactory = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", plainFactory)
                .register("https", sslFactory)
                .build();
        connectionManager = new PoolingHttpClientConnectionManager(registry);
        //设置最大连接数
        connectionManager.setMaxTotal(200);
        //设置每个路由最大连接数
        connectionManager.setDefaultMaxPerRoute(20);
    }

    private synchronized static CloseableHttpClient getHttpClient(){
        if(httpClient==null){
            httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        }

        return httpClient;
    }

    private static HttpEntity getHttpEntity(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet, HttpClientContext.create());
        return response.getEntity();
    }

    private static String getQueryString(Map<String, Object> params) {
        if (params!=null && params.size()>0) {
            StringBuilder query = new StringBuilder();
            for (String key : params.keySet()) {
                Object val = params.get(key);
                if (val == null) {
                    continue;
                }
                if (val instanceof String || val instanceof Number) {
                    query.append(key).append("=").append(val).append("&");
                } else if (val instanceof Number[]) {
                    Number[] arr = (Number[]) val;
                    for (Number a : arr) {
                        query.append(key).append("=").append(a).append("&");
                    }
                } else if (val instanceof String[]) {
                    String[] arr = (String[]) val;
                    for (String a : arr) {
                        query.append(key).append("=").append(a).append("&");
                    }
                } else if (val instanceof int[]) {
                    int[] arr = (int[]) val;
                    for (int a : arr) {
                        query.append(key).append("=").append(a).append("&");
                    }
                } else if (val instanceof double[]) {
                    double[] arr = (double[]) val;
                    for (double a : arr) {
                        query.append(key).append("=").append(a).append("&");
                    }
                } else if (val instanceof long[]) {
                    long[] arr = (long[]) val;
                    for (long a : arr) {
                        query.append(key).append("=").append(a).append("&");
                    }
                }
            }
            String temp = query.toString();
            return temp.length()>0 ? temp.substring(0, temp.length() - 1) : temp;
        }
        return "";
    }

    private static String getMethod(String url, String charset, Map<String, Object> params) throws IOException {
        String queryString = HttpClientUtils.getQueryString(params);
        String requestUrl = StringUtils.isBlank(queryString) ? url : url + "?" + queryString;
        HttpEntity httpEntity = HttpClientUtils.getHttpEntity(requestUrl);
        String result = EntityUtils.toString(httpEntity, charset);
        EntityUtils.consume(httpEntity);
        return result;
    }

    private static String postMethod(String url, String charset, Object param) throws IOException {
        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        StringEntity stringEntity = new StringEntity(JsonUtils.toJsonString(param), charset);
        stringEntity.setContentEncoding(charset);
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        String result = EntityUtils.toString(httpEntity, charset);
        EntityUtils.consume(httpEntity);
        return result;
    }


    public static String doGet(String url) throws IOException {
        return HttpClientUtils.getMethod(url, DEFAULT_CHARSET, null);
    }

    public static String doGet(String url, String charset) throws IOException {
        return HttpClientUtils.getMethod(url, charset, null);
    }

    public static String doGet(String url, Map<String, Object> params) throws IOException {
        return HttpClientUtils.getMethod(url, DEFAULT_CHARSET, params);
    }

    public static String doGet(String url, String charset, Map<String, Object> params) throws IOException {
        return HttpClientUtils.getMethod(url, charset, params);
    }

    public static String doPost(String url, Object param) throws IOException {
        return HttpClientUtils.postMethod(url, DEFAULT_CHARSET, param);
    }

    public static String doPost(String url, String charset, Object param) throws IOException {
        return HttpClientUtils.postMethod(url, charset, param);
    }



}
