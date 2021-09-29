package com.codeup.springblog.controllers;



import com.codeup.springblog.models.Post;

import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();

        allPosts.add(new Post("post!", "post1 body"));
        allPosts.add(new Post("post@", "post2 body"));
        allPosts = postDao.findAll();

        model.addAttribute("posts", allPosts);
        return "/post";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model model) {

        Post post = new Post("Fun title", "Fun body");
        model.addAttribute("postId", id);
        model.addAttribute("post", post);

        return "post/show";
    }

    @GetMapping("/posts/create")

    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/create";
    }

//Old way
//    @PostMapping("/posts/create")
//    public String createAd(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "body") String body
//    ) {
//
//
//        Post adToSubmitToDB = new Post(title, body);
//
//        postDao.save(adToSubmitToDB);
//
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        post.setOwner(userDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditPostForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getById(id);
        model.addAttribute("post", postToEdit);

        return "post/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editAd(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,


            @PathVariable Long id) {

        Post adToSubmitToDB = new Post(id, title, body);

        postDao.save(adToSubmitToDB);

        return "redirect:/posts";


    }


    @PostMapping("/posts/delete/{id}")
    public String deleteAd(
            @PathVariable Long id) {
        Post postToDelete = postDao.getById(id);


        postDao.delete(postToDelete);

        return "redirect:/posts";


    }

}
