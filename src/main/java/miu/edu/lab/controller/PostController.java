package miu.edu.lab.controller;

import miu.edu.lab.domain.Post;
import miu.edu.lab.service.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts/")
public class PostController {
    @Autowired
    private PostServiceImpl postServiceImpl;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping //GET posts/
    public List<Post> getMapping(){
        System.out.println("Set from Controller");
        return postServiceImpl.findAllPosts();
       // return "It Works for get";
    }
    @PostMapping // Post
    public String postMapping(){

        return "Its work with post";
    }

    @GetMapping(headers = {"api-version=v2"})
    public List<Post> findAllPostsV2() {
        return  postServiceImpl.findAllPostsV2();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable int id) {
        return postServiceImpl.findPostById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody Post newPost) {
        if(postServiceImpl.addPost(newPost))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Successfully added.");
        else
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Failed to add." );
    }


}
