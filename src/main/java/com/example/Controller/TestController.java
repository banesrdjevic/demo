package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by banesrdjevic on 6/18/16.
 */

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testItOut(){

        return "Hello World";
    }
}
