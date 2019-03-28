package com.assessment.customerservice.controller;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class AboutController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String AboutService() {
        return "Customer Service version 1.0 ";

    }
}
