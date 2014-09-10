package com.blacklinuxdude.cabin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by kdeleon on 9/9/14.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "ABCDEFG");
        return "welcome";
    }
}
