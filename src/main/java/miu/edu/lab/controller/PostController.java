package miu.edu.lab.controller;

import miu.edu.lab.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts/")
public class PostController {
    @Autowired
    private PostServiceImpl postService;
    @GetMapping //GET posts/
    public String getMapping(){

        return "It Works for get";
    }
    @PostMapping // Post
    public String postMapping(){

        return "Its work with post";
    }

}
