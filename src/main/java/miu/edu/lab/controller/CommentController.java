package miu.edu.lab.controller;

import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.service.CommetService;
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


    //@Lab4ExecutionTime
    //@Lab4LogInfo
    @GetMapping()
    public List<CommentDto> findAll() {
        return commentService.findAll();
    }

   // @Lab4LogInfo
    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable int id) {
        return commentService.findById(id);
    }


    @PostMapping("/{id}")
    public ResponseEntity<String> saveComment(@RequestBody CommentDto newCommentDto) {

        commentService.save(newCommentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added.");
    }

   // @Lab4LogInfo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted...");
    }

}
