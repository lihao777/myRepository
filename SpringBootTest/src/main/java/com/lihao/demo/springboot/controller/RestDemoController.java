package com.lihao.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {
      @RequestMapping("/hello")  
	  public String hello() {
        	return "hello";
        }
}
