package com.flash.test.controller;

import com.flash.flashbootstarter.core.annotation.Controller;
import com.flash.flashbootstarter.mvc.annotation.RequestMapping;
import com.flash.flashbootstarter.mvc.annotation.RequestParam;
import com.flash.flashbootstarter.mvc.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/a")
@Controller
public class TestController {
    @RequestMapping("/s")
    @ResponseBody
    public Map<String,Object> s(){
        Map<String,Object> map=new HashMap<>(  );
        map.put("sdf",232);
        map.put("sdf213","232");
        map.put("s22323df","sdfsdf233432");

        return map;
    }
    @RequestMapping("/c")
    @ResponseBody
    public String cc(@RequestParam("cc") String c){
        return "1234"+c;
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
