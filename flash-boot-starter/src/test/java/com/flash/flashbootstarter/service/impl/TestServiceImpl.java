package com.flash.flashbootstarter.service.impl;

import com.flash.flashbootstarter.core.annotation.Service;
import com.flash.flashbootstarter.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String helloWord() {
        return "hello word";
    }
}