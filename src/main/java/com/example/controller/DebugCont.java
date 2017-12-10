package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// Test controller intercepts all HTTP requests, to activate uncomment annotation Controller
//@Controller
public class DebugCont {

    @RequestMapping("*")
    public @ResponseBody String hello(HttpServletRequest request) {
        System.out.println(request.getServletPath());
        return "page.jsp";
    }
}
