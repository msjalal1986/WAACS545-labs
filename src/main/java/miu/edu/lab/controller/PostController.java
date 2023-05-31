package miu.edu.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts/")
public class PostController {
    @GetMapping //GET posts/
    public String getMapping(){

        return "It Works for get";
    }
    @PostMapping // Post
    public String postMapping(){

        return "Its work with post";
    }

}
