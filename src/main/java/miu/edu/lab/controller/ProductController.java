package miu.edu.lab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @GetMapping //GET api/v1/products
    public String test(){

        return "It Works";
    }
    @PostMapping
    public String testPost(){
        return "Its work with post";
    }
}
