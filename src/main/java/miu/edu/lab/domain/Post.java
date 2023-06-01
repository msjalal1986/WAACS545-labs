package miu.edu.lab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

    public Post(int id, String title, String content, String author) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.author=author;
    }
}
