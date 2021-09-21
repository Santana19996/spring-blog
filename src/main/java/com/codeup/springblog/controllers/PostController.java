package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage(
           ) {
        return "posts index page" ;
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewSinglePage(
   @PathVariable int id ) {
        return "view an individual post" ;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreateForm(
    ) {
        return "view the form for creating a post" + "create a new post" ;
    }





}
