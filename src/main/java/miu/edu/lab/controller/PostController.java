package miu.edu.lab.controller;

import miu.edu.lab.domain.Post;
import miu.edu.lab.service.Impl.PostServiceImpl;
import miu.edu.lab.dto.PostDto;
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
    @GetMapping()
    public List<PostDto> findAllPosts() {
        return postServiceImpl.findAll();
    }

    @GetMapping(headers = {"api-version=v2"})
    public List<PostDto> findAllPostsV2() {
        return  postServiceImpl.findAllV2();
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable int id) {
        return postServiceImpl.findPostById(id);
    }

    @PostMapping
    public ResponseEntity<String> addPost(@RequestBody PostDto newPost) {
        if(postServiceImpl.addPost(newPost))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Successfully added.");
        else
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Failed to add." );
    }

    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable int id) {
        return postServiceImpl.deletePostById(id);
    }

    @PutMapping("/{id}")
    public boolean updatePost(@PathVariable int id, @RequestBody PostDto updatedPost) {
        updatedPost.setId(id);
        return postServiceImpl.updatePost(updatedPost);
    }

}
