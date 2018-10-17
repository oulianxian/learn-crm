package com.kukuou.jsalertify;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author olx
 * @date 2018/10/18/018
 */
@Controller
@RequestMapping()
public class AlertIfyController {
    /**
     * @return
     */
    @RequestMapping()
    public String index(ModelMap modelMap, String alertIfyTag) {
        modelMap.put("alertIfyTag", alertIfyTag);
        return "view";
    }
}
