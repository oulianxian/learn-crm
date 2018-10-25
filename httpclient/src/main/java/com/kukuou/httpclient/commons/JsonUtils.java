package com.kukuou.httpclient.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by lxd on 2017/11/27.
 * json对象公具类
 */
public class JsonUtils {
    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将一个对象转成json字符串
     * @param instance
     * @return
     */
    public static String toJsonString(Object instance){
        try {
            return mapper.writeValueAsString(instance);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转成对象
     * @param jsonString
     * @param type
     * @param <T>
     * @return
     */
    public static  <T> T toBean(String jsonString,Class<T> type){
        try {
            return mapper.readValue(jsonString, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JSON 字符串转集合
     * @param jsonString        JSON 字符串
     * @param collectionClass   集合类型
     * @param elementClasses    集合元素类型
     * @param <T>               返回集合
     * @return
     */
    public static <T> T toCollection(String jsonString, Class<?> collectionClass, Class<?>... elementClasses){
        try {
            return mapper.readValue(jsonString, getCollectionType(collectionClass, elementClasses));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
