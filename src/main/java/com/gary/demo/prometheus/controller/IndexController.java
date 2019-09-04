package com.gary.demo.prometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * index
 *
 * @author gary
 * @date 2019/09/03
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {
        return "server is running";
    }

}