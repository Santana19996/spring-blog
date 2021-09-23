package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;

import com.codeup.springblog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();

        allPosts.add(new Post("post!", "post1 body"));
       allPosts.add(new Post("post@", "post2 body"));
        allPosts = postDao.findAll();

        model.addAttribute("posts", allPosts);
        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model model) {

        Post post = new Post("Fun title", "Fun body");
        model.addAttribute("postId", id);
        model.addAttribute("post", post);

        return "post/show";
    }

    @GetMapping("/posts/create")

    public String showCreatePostForm() {
        return "post/create";
    }




    @PostMapping("/posts/create")
    public String createAd(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {

        Post adToSubmitToDB = new Post(title, body);

        postDao.save(adToSubmitToDB);

        return "redirect:/posts";
    }

}
