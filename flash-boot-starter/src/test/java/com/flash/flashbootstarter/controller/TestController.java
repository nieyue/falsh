package com.flash.flashbootstarter.controller;

import com.flash.flashbootstarter.core.annotation.Controller;
import com.flash.flashbootstarter.ioc.Autowired.Autowired;
import com.flash.flashbootstarter.service.TestService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
    @Autowired
    private TestService testService;

    public void hello() {
        log.info(testService.helloWord());
    }
    public void helloForAspect() {
        log.info("Hello Aspectj");
    }
}

