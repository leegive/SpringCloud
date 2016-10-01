package com.leegive.controller;

import com.leegive.client.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leegive on 30/09/2016.
 */
@RefreshScope
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }

    @RequestMapping(value = "/from", method = RequestMethod.GET)
    public String from(){
        return from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
