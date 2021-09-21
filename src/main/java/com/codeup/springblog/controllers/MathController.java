package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbers(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2 + " is the sum";
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtractNumbers(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2 + " is the difference";

    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2 + " is the product ";

    }


    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNumbers(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2 + " is the quotient ";

    }




}
