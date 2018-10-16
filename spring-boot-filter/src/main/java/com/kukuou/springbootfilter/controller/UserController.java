package com.kukuou.springbootfilter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author olx
 * @date 2018/10/16/016
 */
@Controller
@RequestMapping()
public class UserController {
    /**
     * @return
     */
    @RequestMapping()
    public String index() {
        return "views/index";
    }
    /**
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap, String indexTag) {
        modelMap.put("hello", indexTag);
        return "views/index";
    }
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    public String getUserName(ModelMap modelMap) {
        modelMap.put("user", "olx");
        return "views/index";
    }
}
