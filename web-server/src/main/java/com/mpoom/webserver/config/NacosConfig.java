package com.mpoom.webserver.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class NacosConfig {
    private static final Logger Logger = LoggerFactory.getLogger(NacosConfig.class);

    @NacosValue(value = "${config:default}", autoRefreshed = true)
    private String test;

    public String getConfig() {
        return test;
    }


    @PostConstruct
    public void testConfig() {
        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    Logger.info(getConfig());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
