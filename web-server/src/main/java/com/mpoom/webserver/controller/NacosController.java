package com.mpoom.webserver.controller;

import com.mpoom.webserver.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class NacosController {
    @Autowired
    private NacosConfig nacosConfig;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return nacosConfig.getConfig();
    }
}
