package com.demo.rest;

import com.demo.config.swagger.SwaggerIgnore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elena.miovska on 27.12.2016 г..
 */
@SwaggerIgnore
@RestController
@RequestMapping("/auth")
public class AuthenticationResource {

    @RequestMapping(value = "/user/authenticate", method = RequestMethod.POST, consumes = "application/json")
    public String authenticate() {
        return "Authenticating...";
    }
}
