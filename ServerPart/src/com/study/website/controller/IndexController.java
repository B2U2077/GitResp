package com.study.website.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 * @author FeiJi
 * @date 2021-03-19
 */
@Api(tags = "首页")
@RestController
public class IndexController {
    @RequestMapping({"/","login.html"})
    public String index() {
        return "login";
    }
}
