package com.kukuou.jsonutil.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kukuou.jsonutil.vo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author olx
 * @date 2018/10/27/027
 */
@Controller
public class PeopleController {


    @RequestMapping("getJson")
    public String getJson(HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        People people = new People();
        String msg = request.getParameter("people");  //从前端接收JSON数据
        try {
            people = mapper.readValue(msg, People.class);  //将JSON数据转为类对象
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(people.getName());

        return "hello";
    }
    @RequestMapping("ffff")
    public String index(HttpServletRequest request) {
        return "hello";
    }
}
