package com.assessment.skuservice.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@EnableAutoConfiguration
public class AboutController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String AboutService() {
        return "Sku Service version 1.0 ";

    }
}
