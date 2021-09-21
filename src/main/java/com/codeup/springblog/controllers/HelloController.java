package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class HelloController {
//    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/happy_birthday/{username}/{age}")
    @ResponseBody
    public String helloFromSpring(
            @PathVariable String username,@PathVariable int age) {
        return "Happy Birthday," + username + " Your are now " + age + "years old";
    }


    @GetMapping("/random/number")
    @ResponseBody
    public int RandomNumber() {
        Random r = new Random();
        int low = 10;
        int high = 100;

        return r.nextInt(high - low) + low;
    }

}
