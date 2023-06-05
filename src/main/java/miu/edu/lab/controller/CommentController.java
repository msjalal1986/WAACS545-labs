package miu.edu.lab.controller;

import miu.edu.lab.annotation.ExecutionTimeAnnotation;
import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments/")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;


  @ExecutionTimeAnnotation
    @GetMapping()
    public List<CommentDto> findAll() {
        return commentService.findAll();
    }


    @ExecutionTimeAnnotation
    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable int id) {
        return commentService.findById(id);
    }

@ExecutionTimeAnnotation
    @PostMapping("/{id}")
    public ResponseEntity<String> saveComment(@RequestBody CommentDto newCommentDto) {

        commentService.save(newCommentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added.");
    }

  @ExecutionTimeAnnotation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted...");
    }

}
